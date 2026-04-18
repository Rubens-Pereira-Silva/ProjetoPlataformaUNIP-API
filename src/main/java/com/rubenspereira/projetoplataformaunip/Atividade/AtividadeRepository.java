package com.rubenspereira.projetoplataformaunip.Atividade;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AtividadeRepository extends JpaRepository<AtividadeEntity, Long> {
    List<AtividadeEntity> findAllByNome(String nome);
}
