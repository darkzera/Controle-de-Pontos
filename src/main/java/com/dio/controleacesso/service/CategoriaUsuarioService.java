package com.dio.controleacesso.service;

import com.dio.controleacesso.model.CategoriaUsuario;
import com.dio.controleacesso.model.JornadaTrabalho;
import com.dio.controleacesso.repository.CategoriaUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaUsuarioService {

    CategoriaUsuarioRepository categoriaUsuarioRepository;

    @Autowired
    public CategoriaUsuarioService(CategoriaUsuarioRepository categoriaUsuarioRepository){
        this.categoriaUsuarioRepository = categoriaUsuarioRepository;
    }

    public CategoriaUsuario save(CategoriaUsuario categoriaUsuario){
        return categoriaUsuarioRepository.save(categoriaUsuario);
    }

    public List<CategoriaUsuario> list(){
        return categoriaUsuarioRepository.findAll();
    }

    public Optional<CategoriaUsuario> findById(Long id) throws Exception {
        return categoriaUsuarioRepository.findById(id);
    }

    public void deleteById(Long id) {
        categoriaUsuarioRepository.deleteById(id);
    }


}
