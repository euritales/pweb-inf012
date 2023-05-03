package com.gerencia.sistema.dtos;

import com.gerencia.sistema.entidades.Engenheiro;
import com.gerencia.sistema.entidades.Especialidade;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EngenheiroDto {
    private Long id;
    private String nome;
    private String CREA;
    private Especialidade especialidade;


    public  EngenheiroDto(Engenheiro engenheiro){
        this.id = engenheiro.getId();
        this.nome = engenheiro.getNome();
        this.CREA = engenheiro.getCREA();
        this.especialidade = engenheiro.getEspecialidade();

    }

//    public EngenheiroDto(String nome, Especialidade especialidade) {
//        this.nome = nome;
//        this.especialidade = especialidade;
//    }

    public static EngenheiroDto toDto(Engenheiro engenheiro){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(engenheiro, EngenheiroDto.class);
    }
}

