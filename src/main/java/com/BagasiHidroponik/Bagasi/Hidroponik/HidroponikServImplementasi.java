/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BagasiHidroponik.Bagasi.Hidroponik;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Yapart
 */
@Service
public class HidroponikServImplementasi implements HidroponikService {

     @Autowired
    private HidroponikRepository repository;

    @Override
    public Costumer addCostumer(Costumer costumer) {
        return repository.save(costumer);
    }

    @Override
    public Costumer getCostumerById(int id) {
        return repository.findById(id).get();   
    }

    @Override
    public void updateCostumer(Costumer costumer) {
        Costumer HidroponikDB = repository.findById(costumer.getId()).orElseThrow();
        repository.save(costumer);
    }

    @Override
    public void deleteCostumerById(int id) {
        try{
            repository.deleteById(id);
        }
        catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Costumer> getAllCostumer() {
       return repository.findAll();
    }

}
