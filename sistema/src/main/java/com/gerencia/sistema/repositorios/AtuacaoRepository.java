package com.gerencia.sistema.repositorios;

import com.gerencia.sistema.entidades.Atuacao;
import com.gerencia.sistema.entidades.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtuacaoRepository extends JpaRepository<Atuacao, Long> {
}
