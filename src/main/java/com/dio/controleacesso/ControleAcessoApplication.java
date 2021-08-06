package com.dio.controleacesso;

import com.dio.controleacesso.controller.JornadaTrabalhoController;
import com.dio.controleacesso.model.*;

import com.dio.controleacesso.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ControleAcessoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControleAcessoApplication.class, args);
        System.out.println("--------------------------");



    }

}
