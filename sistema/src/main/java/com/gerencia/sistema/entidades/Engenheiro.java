package com.gerencia.sistema.entidades;

import com.gerencia.sistema.dtos.EngenheiroDto;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "engenheiros")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Engenheiro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String CREA;
	@Enumerated(EnumType.STRING)
	private Especialidade especialidade=Especialidade.CIVIL;


	public Engenheiro(EngenheiroDto engenheiroDto){
		super();
		this.id = engenheiroDto.getId();
		this.nome = engenheiroDto.getNome();
		this.CREA = engenheiroDto.getCREA();
		this.especialidade = engenheiroDto.getEspecialidade();
	}
}

