package com.rubenspereira.projetoplataformaunip.Atividade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class AtividadeService {

    @Autowired
    AtividadeRepository atividadeRepository;

    public AtividadeEntity getAtividade(Long id){
        return atividadeRepository.findById(id).get();
    }

    public List<AtividadeEntity> getAtividades(){
        return atividadeRepository.findAll();
    }

    public List<AtividadeEntity> getAtividades(String nome){
        return atividadeRepository.findAllByNome(nome);
    }

    public AtividadeEntity salvarAtividade(@RequestBody AtividadeEntity atividade){
        return atividadeRepository.save(atividade);
    }

    public void deletarAtividade(Long id){
        atividadeRepository.deleteById(id);
    }
}
