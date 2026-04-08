package com.rubenspereira.projetoplataformaunip.Desafio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesafioService {

    private final DesafioRepository desafioRepository;

    public DesafioService(DesafioRepository desafioRepository) {
        this.desafioRepository = desafioRepository;
    };

    //Criar desafios no Banco
    public DesafioEntity PostDesafio(DesafioEntity desafio){
        return desafioRepository.save(desafio);
    }

    //Pega o desafio com base no ID
    public DesafioEntity GetDesafio(Long id){
        if(desafioRepository.findById(id).isPresent()){
            return desafioRepository.findById(id).get();
        }
        return null;
    }

    //Pega todos os desafios no banco
    public List<DesafioEntity> GetAllDesafios(){
        return  desafioRepository.findAll();
    }

    //Deleta o Desafio no banco
    public String DeleteDesafio(Long id){
        if(desafioRepository.findById(id).isPresent()){
            desafioRepository.deleteById(id);
            return "Desafio Deletado com sucesso";
        }
        return "Desafio não encontrado";
    }
}
