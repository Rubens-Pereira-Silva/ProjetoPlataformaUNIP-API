package com.rubenspereira.projetoplataformaunip.Usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

    //logar usuario
    public Long login(LoginRequest loginData){
        Optional<UsuarioEntity> usuario = usuarioRepository.findByEmail(loginData.getEmail());

        if(usuario.isEmpty()){
            return null;
        }

        //Compara a senha
        if(usuario.get().getSenha().equals(loginData.getSenha())){
            return  usuario.get().getId();
        }
        return null;
    }

    //Cadastra um novo usuario no banco
    public UsuarioEntity cadastrarUsuario(UsuarioEntity usuario){
        return usuarioRepository.saveAndFlush(usuario);
    }

    //Buscar usuario
    public UsuarioDTO buscarUsuarioPorId(Long id){
       Optional<UsuarioEntity> usuario = usuarioRepository.findById(id);
       return new UsuarioDTO(usuario.get());
    }

    //Buscar top usuarios
    public List<UsuarioDTO> buscarTopUsuarios(){
        return usuarioRepository.findTop10ByOrderByMoedasDesc()
                .stream()
                .map(UsuarioDTO::new)
                .collect(Collectors.toList());
    }

    //Adicionar Moedas
    public UsuarioDTO adicionarMoedas(long id, int moedas){
        usuarioRepository.findById(id).ifPresent(usuario -> {
            usuario.setMoedas(usuario.getMoedas() + moedas);

            usuarioRepository.save(usuario);
        });

        return new UsuarioDTO(usuarioRepository.findById(id).get());
    }

    //Lista todos o Usuarios
    public List<UsuarioEntity> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    //Deletar Usuario
    public String deletarUsuario(@RequestParam Long id){
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuarioRepository.delete(usuario);
                    return "Usuario deletado com sucesso!";
                })
                .orElse("Usuario não encontrado!");
    }

    //Loja
    public UsuarioDTO comprarIcon(Long id, String icon){
        usuarioRepository.findById(id).ifPresent(usuario -> {
            usuario.setIcon(icon);
            usuarioRepository.save(usuario);
        });
        return new UsuarioDTO(usuarioRepository.findById(id).get());
    }
}
