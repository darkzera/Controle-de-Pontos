package com.dio.controleacesso.controller;

import com.dio.controleacesso.model.JornadaTrabalho;
import com.dio.controleacesso.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    @Autowired
    JornadaService jornadaService;

    @PostMapping
    public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.saveJornada(jornadaTrabalho);
    }

    @GetMapping("/lista")
    public List<JornadaTrabalho> listJornadas(){
        return jornadaService.listJornadas();
    }

    @GetMapping("/{idJornada}")
    public ResponseEntity<JornadaTrabalho> findById(@PathVariable("idJornada") String idJornada) throws Exception {
        Long id = Long.valueOf(idJornada);
        return ResponseEntity.ok(jornadaService
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Element ID not found")));
    }

    @DeleteMapping("/{idJornada}")
    public void deleteById(@PathVariable("idJornada") Long idJornada) throws Exception {
        Long id = Long.valueOf(idJornada);
        jornadaService.deleteById(id);
    }

/*
    @PostMapping
    public JornadaTrabalho updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.saveJornada(jornadaTrabalho);
    }
*/


}
