package com.example.desafio.produto.presente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/presentes")
public class PresenteResource {

    @Autowired private PresenteService presenteService;

    @GetMapping()
    public List<Presente> searchPresente() {
        return presenteService.searchPresente();
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Presente> getPresenteById(@PathVariable(value = "id") Long id) {
        return presenteService.getPresenteById(id);
    }

    @PostMapping(path = "save")
    public Presente savePresente(@RequestBody Presente presente) {
        return presenteService.createPresente(presente);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Presente> updatePresente(@PathVariable(value = "id") Long id, @RequestBody Presente presenteDetails) {
        return presenteService.updatePresente(id, presenteDetails);
    }

    @DeleteMapping(path =  "{id}")
    public ResponseEntity<?> deletePresente(@PathVariable(value = "id") Long id) {
        return presenteService.deletePresente(id);
    }
}
