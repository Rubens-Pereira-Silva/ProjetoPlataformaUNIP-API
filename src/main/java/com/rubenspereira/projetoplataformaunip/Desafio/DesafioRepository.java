package com.rubenspereira.projetoplataformaunip.Desafio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesafioRepository extends JpaRepository<DesafioEntity, Long>{
}
