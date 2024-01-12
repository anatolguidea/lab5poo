package com.example.demo.controller;

import com.example.demo.entity.Comenzi;
import com.example.demo.service.ComenziService;
import com.example.demo.service.CumparatoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comenzi")
public class ComenziController {
    @Autowired
    private ComenziService comenziService;

    // Endpoint pentru obținerea tuturor comenzilor
    @GetMapping
    public List<Comenzi> findAll() {
        return comenziService.findAll();
    }

    // Endpoint pentru obținerea unei comenzi după ID
    @GetMapping("{comandaID}")
    public List<Comenzi> findByComandaID(@PathVariable int comandaID) {
        return comenziService.findByComandaID(comandaID);
    }
    @GetMapping("cumparatorID")
    public List<Comenzi> findByCumparatorID(@RequestParam int cumparatorID) {
        return comenziService.findByCumparatorID(cumparatorID);
    }

    // Endpoint pentru crearea unei noi comenzi
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createComanda(@RequestBody Comenzi comenzi) {
        comenziService.createComanda(comenzi);
    }

    // Endpoint pentru actualizarea unei comenzi existente
    @PutMapping("/{comandaID}")
    public void updateComanda(@PathVariable int comandaID, @RequestBody Comenzi comenzi) {
         comenziService.updateComanda(comandaID, comenzi);
    }

    // Endpoint pentru ștergerea unei comenzi după ID
    @DeleteMapping("/{comandaID}")
    public void deleteComanda(@PathVariable int comandaID) {
        comenziService.deleteComanda(comandaID);
    }
}

