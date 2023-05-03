package com.gerencia.sistema.repositorios;

import com.gerencia.sistema.entidades.Engenheiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EngenheiroRepository extends JpaRepository<Engenheiro, Long> {
}
