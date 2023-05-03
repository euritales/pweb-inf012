package com.gerencia.sistema.repositorios;

import com.gerencia.sistema.entidades.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
