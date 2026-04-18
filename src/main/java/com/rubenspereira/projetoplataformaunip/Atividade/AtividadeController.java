package com.rubenspereira.projetoplataformaunip.Atividade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/atividade")
public class AtividadeController {

    @Autowired
    AtividadeService atividadeService;

    //Pegar Atividade
    @GetMapping
    public AtividadeEntity getAtividade(@RequestParam Long id){
        return atividadeService.getAtividade(id);
    }

    //Pegar todas as atividades
    @GetMapping("/all")
    public List<AtividadeEntity> getAllAtividades(){
        return atividadeService.getAtividades();
    }

    //Pegar atividades de mesmo nome
    @GetMapping("/nome")
    public List<AtividadeEntity> getAtividades(@RequestParam String nome){
        return atividadeService.getAtividades(nome);
    }


    @PostMapping
    public AtividadeEntity salvarAtividade(@RequestBody AtividadeEntity atividade){
        return  atividadeService.salvarAtividade(atividade);
    }

    @DeleteMapping
    public void deleteAtividade(@RequestParam Long id){
        atividadeService.deletarAtividade(id);
    }
}
