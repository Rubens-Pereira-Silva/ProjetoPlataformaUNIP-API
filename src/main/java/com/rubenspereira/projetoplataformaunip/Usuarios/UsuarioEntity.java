package com.rubenspereira.projetoplataformaunip.Usuarios;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nome;
    @Column(unique = true, nullable = false)
    String email;
    String senha;
    int moedas = 100;
    int nivel = 1;

    public UsuarioEntity() {
    }
}
