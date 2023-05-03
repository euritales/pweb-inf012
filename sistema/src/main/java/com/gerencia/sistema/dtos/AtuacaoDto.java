package com.gerencia.sistema.dtos;

import com.gerencia.sistema.entidades.Atuacao;
import com.gerencia.sistema.entidades.Engenheiro;
import com.gerencia.sistema.entidades.Projeto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AtuacaoDto {

    private Long id;
    private String engenheiro;
    private String projeto;
    private int duracao;

    public AtuacaoDto(Atuacao atuacao){
        this.id = atuacao.getId();
        this.duracao = atuacao.getDuracao();
        this.engenheiro = atuacao.getEngenheiro().getNome();
        this.projeto = atuacao.getProjeto().getNome();

    }

    public static AtuacaoDto toDto(Atuacao atuacao){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(atuacao, AtuacaoDto.class);
    }


}
