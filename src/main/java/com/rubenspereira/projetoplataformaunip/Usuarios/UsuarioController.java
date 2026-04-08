package com.rubenspereira.projetoplataformaunip.Usuarios;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //Login
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginData){
        return usuarioService.login(loginData);
    }

    @GetMapping
    public List<UsuarioDTO> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    @PostMapping()
    public UsuarioEntity criarUsuario(@RequestBody UsuarioEntity usuario){
        return usuarioService.cadastrarUsuario(usuario);
    }

    @DeleteMapping
    public String deletarUsuario(@RequestParam Long id){
        return  usuarioService.deletarUsuario(id);
    }
}
