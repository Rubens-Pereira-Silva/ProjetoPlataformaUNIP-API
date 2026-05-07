package com.rubenspereira.projetoplataformaunip.Usuarios;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Long> {
    Optional<UsuarioEntity> findByEmail(String email);
    List<UsuarioEntity> findTop10ByOrderByMoedasDesc();
}
