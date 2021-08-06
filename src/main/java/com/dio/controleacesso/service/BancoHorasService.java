package com.dio.controleacesso.service;

import com.dio.controleacesso.model.BancoHoras;
import com.dio.controleacesso.repository.BancoHorasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BancoHorasService {

    BancoHorasRepository bancoHorasRepository;

    @Autowired
    public BancoHorasService(BancoHorasRepository bancoHorasRepository){
       this.bancoHorasRepository = bancoHorasRepository;
    }

    public BancoHoras createBancoHoras(BancoHoras bancoHoras){
        return bancoHorasRepository.save(bancoHoras);
    }

    public List<BancoHoras> listaBancoHoras(){
        return bancoHorasRepository.findAll();
    }

    public BancoHoras getById(Long id){
        return bancoHorasRepository.getById(id);
    }

    public Optional<BancoHoras> findById(Long id)throws Exception{
       return bancoHorasRepository.findById(id);
    }

    public void deleteById(Long id){
        bancoHorasRepository.deleteById(id);
    }



}
