package com.gerencia.sistema.controladores;

import com.gerencia.sistema.entidades.Engenheiro;
import com.gerencia.sistema.entidades.Projeto;
import com.gerencia.sistema.servicos.EngenheiroService;
import com.gerencia.sistema.servicos.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projeto")
public class ProjetoController {


    @Autowired
    private ProjetoService service;


    @GetMapping
    ResponseEntity listarProjetos(){
        return ResponseEntity.ok(service.listagemProjetos());
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity cadastrarProjetos(@RequestBody Projeto projeto){
        service.cadastroProjeto(projeto);
        return ResponseEntity.created(null).build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ResponseEntity editarProjeto(@PathVariable("id") Long id, @RequestBody Projeto projeto){
        return ResponseEntity.ok(service.edicaoProjeto(id, projeto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ResponseEntity excluirProjeto(@PathVariable("id") Long id){
        service.exclusaoProjeto(id);
        return ResponseEntity.noContent().build();
    }


}
