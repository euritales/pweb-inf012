package com.gerencia.sistema.servicos;

import com.gerencia.sistema.dtos.ProjetoDto;
import com.gerencia.sistema.dtos.ResProjetoDto;
import com.gerencia.sistema.entidades.Projeto;
import com.gerencia.sistema.repositorios.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository repository;

    public List<ResProjetoDto> listagemProjetos() {
        return repository.findAll().stream().map(
                ResProjetoDto::new
        ).collect(Collectors.toList());
    }

    public ProjetoDto cadastroProjeto(Projeto projeto) {
        Assert.isNull(projeto.getId(), "Não foi possivel salvar este registro");
        return ProjetoDto.toDto(repository.save(projeto));
    }


    public Object edicaoProjeto(Long id, Projeto projeto) {
        Assert.isNull(projeto.getId(), "Não foi possivel salvar este registro");

        repository.findById(id)
                .map(projetoAtual -> {
                    projeto.setId(projetoAtual.getId());
                    ProjetoDto.toDto(
                            repository.save(projeto)
                    );
                    return projetoAtual;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Projeto não encontrado."));
        return null;
    }

    public ProjetoDto exclusaoProjeto(Long id) {
        repository.findById(id).map(projetoAtual -> {
                    repository.delete(projetoAtual);
                    return new ResponseStatusException(HttpStatus.OK);
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Projeto não encontrada."));
        return null;
    }
}
