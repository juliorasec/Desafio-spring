package com.example.desafio.produto.presente;

import com.example.desafio.produto.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalogo")
public class CatalogoResource {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<?> getRelatorio() {
        return new ResponseEntity<>(service.getTop10Notas(), HttpStatus.OK);
    }
}
