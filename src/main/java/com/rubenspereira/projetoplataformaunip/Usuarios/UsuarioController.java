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

    @GetMapping
    public UsuarioDTO getUsuario(@RequestParam Long id){
        return usuarioService.buscarUsuarioPorId(id);
    }

    @GetMapping("/all")
    public List<UsuarioEntity> listarUsuarios(){
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
