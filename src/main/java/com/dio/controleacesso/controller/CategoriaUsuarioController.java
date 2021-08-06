package com.dio.controleacesso.controller;

import com.dio.controleacesso.model.CategoriaUsuario;
import com.dio.controleacesso.service.CategoriaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/categoriausuario")
public class CategoriaUsuarioController {

    @Autowired
    CategoriaUsuarioService categoriaUsuarioService;

    @PostMapping
    public CategoriaUsuario create(@RequestBody CategoriaUsuario categoriaUsuario){
        return categoriaUsuarioService.save(categoriaUsuario);
    }

    @GetMapping("/lista")
    public List<CategoriaUsuario> list(){
        return categoriaUsuarioService.list();
    }

    @GetMapping("/{id_}")
    public ResponseEntity<CategoriaUsuario> findById(@PathVariable("id_") String id_) throws Exception {
        Long id = Long.valueOf(id_);
        return ResponseEntity.ok(categoriaUsuarioService
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Element ID not found")));
    }

    @DeleteMapping("/{idJornada}")
    public void deleteById(@PathVariable("idJornada") Long id_) throws Exception {
        Long id = Long.valueOf(id_);
        categoriaUsuarioService.deleteById(id);
    }

}
