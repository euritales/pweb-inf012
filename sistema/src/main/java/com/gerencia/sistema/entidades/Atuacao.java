package com.gerencia.sistema.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "atuacoes")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Atuacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
    @JoinColumn(name = "engenheiro_id")
	private Engenheiro engenheiro;
	@ManyToOne
    @JoinColumn(name = "projeto_id")
	private Projeto projeto;
	private int duracao;

}
