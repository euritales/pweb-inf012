package com.gerencia.sistema.controladores;

import com.gerencia.sistema.dtos.EngenheiroDto;
import com.gerencia.sistema.entidades.Engenheiro;
import com.gerencia.sistema.servicos.EngenheiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/engenheiro")
public class EngenheiroController {


    @Autowired
    private EngenheiroService service;


    @GetMapping
    ResponseEntity listarEngenheiros(){
        return ResponseEntity.ok(service.listagemEngenheiros());
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity cadastrarEngenheiro(@RequestBody Engenheiro engenheiro){
        service.cadastroEngenheiro(engenheiro);
        return ResponseEntity.created(null).build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ResponseEntity editarEngenheiro(@PathVariable("id") Long id, @RequestBody Engenheiro engenheiro){
        return ResponseEntity.ok(service.edicaoEngenheiro(id, engenheiro));
    }

//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    ResponseEntity excluirEngenheiro(@PathVariable("id") Long id){
//        service.exclusaoEngenheiro(id);
//        return ResponseEntity.noContent().build();
//    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity deleteTaxa(@PathVariable Long id) {
        service.excluirEngenheiro(id);
        return ResponseEntity.noContent().build();
    }

}
