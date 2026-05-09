package com.rubenspereira.projetoplataformaunip.Usuarios;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

    UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //Login
    @PostMapping("/login")
    public Long login(@RequestBody LoginRequest loginData){
        return usuarioService.login(loginData);
    }

    @GetMapping("/{id}")
    public UsuarioDTO getUsuario(@PathVariable Long id){
        return usuarioService.buscarUsuarioPorId(id);
    }

    @GetMapping("/all")
    public List<UsuarioEntity> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/top")
    public List<UsuarioDTO> topUsuarios(){
        return  usuarioService.buscarTopUsuarios();
    }

    @PostMapping()
    public UsuarioEntity criarUsuario(@RequestBody UsuarioEntity usuario){
        return usuarioService.cadastrarUsuario(usuario);
    }
    @PostMapping("/moedas/{id}")
    public UsuarioDTO adicionarMoedas(@PathVariable Long id, @RequestBody int moedas){
        return usuarioService.adicionarMoedas(id, moedas);
    }

    @DeleteMapping
    public String deletarUsuario(@RequestParam Long id){
        return  usuarioService.deletarUsuario(id);
    }

    //Loja

    @PutMapping("/loja/icon/{id}")
    public UsuarioDTO comprarIcon(@PathVariable Long id, @RequestBody String icon){
        return usuarioService.comprarIcon(id, icon);
    }


    //Terminou a atividade
    @PutMapping("/level/{idUsuario}/{nivelAtividade}")
    public UsuarioDTO atualizarLevel(@PathVariable Long idUsuario, @PathVariable Long nivelAtividade){
        return usuarioService.atualizarLevel(idUsuario, nivelAtividade);
    }
}
