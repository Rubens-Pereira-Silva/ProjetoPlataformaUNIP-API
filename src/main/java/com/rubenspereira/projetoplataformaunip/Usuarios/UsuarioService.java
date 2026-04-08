package com.rubenspereira.projetoplataformaunip.Usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    //logar usuario
    public String login(LoginRequest loginData){
        Optional<UsuarioEntity> usuario = usuarioRepository.findByEmail(loginData.getEmail());

        if(usuario.isEmpty()){
            return "Usuario não encontrado";
        }

        //Compara a senha
        if(usuario.get().getSenha().equals(loginData.getSenha())){
            return "Login realizado para ".concat(usuario.get().getNome());
        }
        return "Senha Incorreta";
    }

    //Cadastra um novo usuario no banco
    public UsuarioEntity cadastrarUsuario(UsuarioEntity usuario){
        return usuarioRepository.saveAndFlush(usuario);
    }

    //Lista todos o Usuarios
    public List<UsuarioDTO> listarUsuarios(){
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioDTO::new)
                .toList();
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
}
