package com.rubenspereira.projetoplataformaunip.Desafio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/desafio")
public class DesafioController {

    @Autowired
    private DesafioService desafioService;

    //Busca um Desafio usando o ID
    @GetMapping
    public List<DesafioEntity> getDesafio(@RequestBody ArrayList<Long> IDs){
        return desafioService.GetDesafio(IDs);
    }

    //Busca Todos os Desafios
    @GetMapping("/all")
    public List<DesafioEntity> getDesafios(){
        return desafioService.GetAllDesafios();
    }


    //Cria um novo desafio
    @PostMapping
    public DesafioEntity postDesafio(@RequestBody DesafioEntity desafio){
        return desafioService.PostDesafio(desafio);
    }

    //Deleta um Desafio usando o ID
    @DeleteMapping
    public String deleteDesafio(@RequestParam long id){
        return desafioService.DeleteDesafio(id);
    }
}
