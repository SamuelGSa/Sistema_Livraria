package com.example.demo.controller;

import com.example.demo.model.Livro;
import com.example.demo.repository.LivrariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/livrariasaraaaiva")
public class LivrariaController {

    @Autowired
    private LivrariaRepository livrariaRepository;

    @GetMapping
    public ResponseEntity<List<Livro>> findAll() {
        List<Livro> findAllBooks = livrariaRepository.findAll();
        return new ResponseEntity<>(findAllBooks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Livro>> findById(@PathVariable UUID id){
        Optional<Livro> findBookById = livrariaRepository.findById(id);
        return new ResponseEntity<>(findBookById, HttpStatus.OK);
    }

    @PostMapping("/salvar")
    public ResponseEntity<Livro> create(@RequestBody Livro livro){
        return new ResponseEntity<>(livrariaRepository.save(livro),HttpStatus.CREATED);
    }

}
