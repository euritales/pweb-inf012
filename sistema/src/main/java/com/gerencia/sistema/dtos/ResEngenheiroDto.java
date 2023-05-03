package com.gerencia.sistema.dtos;

import com.gerencia.sistema.entidades.Engenheiro;
import com.gerencia.sistema.entidades.Especialidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResEngenheiroDto {
    private String nome;
    private Especialidade especialidade;


    public ResEngenheiroDto(Engenheiro engenheiro){
        this.nome = engenheiro.getNome();
        this.especialidade = engenheiro.getEspecialidade();

    }

    public static ResEngenheiroDto toDto(Engenheiro engenheiro){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(engenheiro, ResEngenheiroDto.class);
    }
}

