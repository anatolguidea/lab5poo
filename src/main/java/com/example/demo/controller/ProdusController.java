package com.example.demo.controller;

import com.example.demo.entity.Cumparatori;
import com.example.demo.entity.Produs;
import com.example.demo.service.ProdusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produs")
public class ProdusController {
    @Autowired
    private ProdusService produsService;

    @GetMapping
    public List<Produs> findAll() {
        return produsService.findAll();
    }

    @GetMapping("/{codProdus}")
    public List<Produs> findByCodProdus(@PathVariable int codProdus) {
        return produsService.findByCodProdus(codProdus);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProdus(@RequestBody Produs produs) {
        produsService.createProdus(produs);
    }

    @PutMapping("/{codProdus}")
    public void updateProdus(@PathVariable int codProdus, @RequestBody Produs produs) {
        produsService.updateProdus(codProdus, produs);
    }

    @DeleteMapping("/{codProdus}")
    public void deleteProdus(@PathVariable int codProdus) {
        produsService.deleteProdus(codProdus);
    }
}
