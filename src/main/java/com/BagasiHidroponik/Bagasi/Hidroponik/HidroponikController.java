/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BagasiHidroponik.Bagasi.Hidroponik;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Yapart
 */
@RestController
@CrossOrigin
@RequestMapping("/hidroponik")
public class HidroponikController {
    
    @Autowired
    HidroponikService hidroponikservice;
        
    @GetMapping
    public List<Costumer> getAllCostumer(){
        return hidroponikservice.getAllCostumer();
    }
    
    @PostMapping
    @ResponseStatus
    public Costumer addCostumer(@RequestBody Costumer costumer){
        return hidroponikservice.addCostumer(costumer);
    }
    
    @GetMapping("/{id}")
    public Costumer getCostumerById(@PathVariable("id") int id){
        return hidroponikservice.getCostumerById(id);
    }
    
    @PutMapping("/updatehidroponik")
    public ResponseEntity<String> updateCostumer(@RequestBody Costumer costumer){
        try{
            hidroponikservice.updateCostumer(costumer);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
        
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCostumerById(@PathVariable int id){
        try{
            hidroponikservice.deleteCostumerById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
