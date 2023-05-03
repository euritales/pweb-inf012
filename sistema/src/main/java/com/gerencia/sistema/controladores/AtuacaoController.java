package com.gerencia.sistema.controladores;

import com.gerencia.sistema.entidades.Atuacao;
import com.gerencia.sistema.entidades.Projeto;
import com.gerencia.sistema.servicos.AtuacaoService;
import com.gerencia.sistema.servicos.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/atuacao")
public class AtuacaoController {


    @Autowired
    private AtuacaoService service;


    @GetMapping
    ResponseEntity listarAtuacoes(){
        return ResponseEntity.ok(service.listagemAtuacoes());
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity cadastrarAtuacao(@RequestBody Atuacao atuacao){
        service.cadastroAtuacao(atuacao);
        return ResponseEntity.created(null).build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ResponseEntity editarAtuacao(@PathVariable("id") Long id, @RequestBody Atuacao atuacao){
        return ResponseEntity.ok(service.edicaoAtuacao(id, atuacao));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ResponseEntity excluirAtuacao(@PathVariable("id") Long id){
        service.exclusaoAtuacao(id);
        return ResponseEntity.noContent().build();
    }


}
