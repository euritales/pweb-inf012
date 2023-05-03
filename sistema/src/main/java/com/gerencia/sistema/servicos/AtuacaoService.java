package com.gerencia.sistema.servicos;

import com.gerencia.sistema.dtos.AtuacaoDto;
import com.gerencia.sistema.entidades.Atuacao;
import com.gerencia.sistema.repositorios.AtuacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtuacaoService {

    @Autowired
    private AtuacaoRepository repository;

    public List<AtuacaoDto> listagemAtuacoes() {
        return repository.findAll().stream().map(
                AtuacaoDto::new
        ).collect(Collectors.toList());
    }

    public AtuacaoDto cadastroAtuacao(Atuacao atuacao) {
        Assert.isNull(atuacao.getId(), "Não foi possivel salvar este registro");
        return AtuacaoDto.toDto(repository.save(atuacao));
    }


    public Object edicaoAtuacao(Long id, Atuacao atuacao) {
        Assert.isNull(atuacao.getId(), "Não foi possivel salvar este registro");

        repository.findById(id)
                .map(atuacaoAtual -> {
                    atuacao.setId(atuacaoAtual.getId());
                    AtuacaoDto.toDto(
                            repository.save(atuacao)
                    );
                    return atuacaoAtual;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Atuacao não encontrada."));
        return null;
    }

    public AtuacaoDto exclusaoAtuacao(Long id) {
        repository.findById(id).map(atuacaoAtual -> {
                    repository.delete(atuacaoAtual);
                    return new ResponseStatusException(HttpStatus.OK);
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                      "Atuacao não encontrada."));
        return null;
    }
}
