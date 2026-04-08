package com.rubenspereira.projetoplataformaunip.Usuarios;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {

    String nome;
    int moedas;
    int nivel;

    public UsuarioDTO(UsuarioEntity usuario){
        this.nome = usuario.getNome();
        this.moedas = usuario.getMoedas();
        this.nivel = usuario.getNivel();
    };

}
