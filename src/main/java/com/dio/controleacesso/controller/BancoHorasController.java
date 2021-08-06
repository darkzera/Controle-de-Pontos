package com.dio.controleacesso.controller;

import com.dio.controleacesso.model.BancoHoras;
import com.dio.controleacesso.service.BancoHorasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bancohoras")
public class BancoHorasController {

    @Autowired
    private BancoHorasService bancoHorasService;

    @PostMapping
    public BancoHoras createBancoHoras(@RequestBody BancoHoras bancoHoras){
        return bancoHorasService.createBancoHoras(bancoHoras);
    }

    @GetMapping("/lista")
    public List<BancoHoras> listBancoHoras(){
        return bancoHorasService.listaBancoHoras();
    }

}
