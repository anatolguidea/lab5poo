package com.example.demo.controller;

import com.example.demo.entity.Cumparatori;

import com.example.demo.service.CumparatoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cumparatori")
public class CumparatoriController {
    @Autowired
    private CumparatoriService cumparatoriService;

    @GetMapping
    public List<Cumparatori> findAll() {
        return cumparatoriService.findAll();
    }

    @GetMapping("/{cumparatorID}")
    public List<Cumparatori> findByCumparatorID(@PathVariable int cumparatorID) {
        return cumparatoriService.findByCumparatorID(cumparatorID);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCumparator(@RequestBody Cumparatori cumparatori) {
        cumparatoriService.createCumparator(cumparatori);
    }

    @PutMapping("/{cumparatorID}")
    public void updateCumparator(@PathVariable int cumparatorID, @RequestBody Cumparatori cumparatori) {
        cumparatoriService.updateCumparator(cumparatorID, cumparatori);
    }

    @DeleteMapping("/{cumparatorID}")
    public void deleteCumparator(@PathVariable int cumparatorID) {
        cumparatoriService.deleteCumparator(cumparatorID);
    }
}
