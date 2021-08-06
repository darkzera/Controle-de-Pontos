package com.dio.controleacesso.service;

import com.dio.controleacesso.model.JornadaTrabalho;
import com.dio.controleacesso.repository.JornadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JornadaService {

    JornadaRepository jornadaRepository;

    @Autowired
    public JornadaService(JornadaRepository jornadaRepository){
        this.jornadaRepository = jornadaRepository;
    }

    public JornadaTrabalho saveJornada(JornadaTrabalho jornadaTrabalho){
        return jornadaRepository.save(jornadaTrabalho);
    }

    public List<JornadaTrabalho> listJornadas(){
        return jornadaRepository.findAll();
    }

    public Optional<JornadaTrabalho> findById(Long id) throws Exception {
        return jornadaRepository.findById(id);
    }

    public void deleteById(Long id) {
        jornadaRepository.deleteById(id);
    }

//    public JornadaTrabalho updateJornada(JornadaTrabalho jornadaTrabalho){
//        return jornadaRepository.save(jornadaTrabalho);
//    }

}
