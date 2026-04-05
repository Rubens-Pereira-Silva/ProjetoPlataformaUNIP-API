package com.rubenspereira.projetoplataformaunip.Desafio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@Entity
public class DesafioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String type;
    String pergunta;
    ArrayList<String> resposta;
    String tema;

    public DesafioEntity(){}

    public DesafioEntity(String type, String pergunta, ArrayList<String> resposta, String tema) {
        this.type = type;
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.tema = tema;
    }

}
