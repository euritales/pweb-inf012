package com.gerencia.sistema.dtos;

import com.gerencia.sistema.entidades.Categoria;
import com.gerencia.sistema.entidades.Projeto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResProjetoDto {

	private String nome;
	private Categoria categoria=Categoria.PÚBLICO;

	public ResProjetoDto(Projeto projeto){
		this.nome = projeto.getNome();
		this.categoria = projeto.getCategoria();
	}
	public static ResProjetoDto toDto(Projeto projeto){
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(projeto, ResProjetoDto.class);
	}
}

