package com.gerencia.sistema.servicos;

import com.gerencia.sistema.dtos.EngenheiroDto;
import com.gerencia.sistema.dtos.ResEngenheiroDto;
import com.gerencia.sistema.entidades.Engenheiro;
import com.gerencia.sistema.repositorios.EngenheiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EngenheiroService {

    @Autowired
    private EngenheiroRepository repository;

    public List<ResEngenheiroDto> listagemEngenheiros() {
        return repository.findAll().stream().map(
                ResEngenheiroDto::new
        ).collect(Collectors.toList());
    }

    public EngenheiroDto cadastroEngenheiro(Engenheiro engenheiro) {
        Assert.isNull(engenheiro.getId(), "Não foi possivel salvar este registro");
        return EngenheiroDto.toDto(repository.save(engenheiro));
    }


    public Object edicaoEngenheiro(Long id, Engenheiro engenheiro) {
        Assert.isNull(engenheiro.getId(), "Não foi possivel salvar este registro");

        repository.findById(id)
                .map(engenheiroAtual -> {
                    engenheiro.setId(engenheiroAtual.getId());
                    EngenheiroDto.toDto(
                            repository.save(engenheiro)
                    );
                    return engenheiroAtual;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Engenheiro não encontrado."));
        return null;
    }

    public EngenheiroDto excluirEngenheiro(Long id) {
        repository.findById(id).map(engenheiroAtual -> {
                    repository.delete(engenheiroAtual);
                    return new ResponseStatusException(HttpStatus.OK);
                 }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Não encontrado."));
        return null;
    }
}
