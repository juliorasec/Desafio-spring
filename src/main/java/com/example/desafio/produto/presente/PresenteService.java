package com.example.desafio.produto.presente;

import com.example.desafio.produto.chocolate.Chocolate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class PresenteService {

    @Autowired private PresenteRepository repository;

    private Presente replaceInfo(Long id, Presente presenteInformation) {
        presenteInformation.setId(id);
        return presenteInformation;
    }

    public Presente createPresente(Presente presente) {
        return repository.save(presente);
    }

    public List<Presente> searchPresente() {
        return (List<Presente>) repository.findAll();
    }

    public ResponseEntity<Presente> getPresenteById(Long id) {
        try {
            Presente presente = repository.findById(id)
                    .orElseThrow();
            return ResponseEntity.ok(presente);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Presente> updatePresente(Long id, Presente presenteDetails) {
        Presente presente = replaceInfo(id, presenteDetails);
        return ResponseEntity.ok(createPresente(presente));
    }

    private void deletePresente(Presente presente) {
        repository.delete(presente);
    }

    public ResponseEntity<?> deletePresente(Long id) {
        try {
            Presente presente = repository.findById(id)
                    .orElseThrow();
            deletePresente(presente);
        }catch(NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    public Iterable<Presente> saveAll(Iterable<Presente> presentes) {
        return repository.saveAll(presentes);
    }
}
