package com.gerencia.sistema.dtos;

import com.gerencia.sistema.entidades.Categoria;
import com.gerencia.sistema.entidades.Engenheiro;
import com.gerencia.sistema.entidades.Projeto;
import jakarta.persistence.*;
import lombok.*;
import org.modelmapper.ModelMapper;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjetoDto {

	private Long id;
	private String nome;
	private double custo;
	private Categoria categoria=Categoria.PÚBLICO;

	public ProjetoDto(Projeto projeto){
		this.id = projeto.getId();
		this.nome = projeto.getNome();
		this.custo = projeto.getCusto();
		this.categoria = projeto.getCategoria();
	}
	public static ProjetoDto toDto(Projeto projeto){
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(projeto, ProjetoDto.class);
	}
}

