package com.example.demo.service;

import com.example.demo.entity.Comenzi;
import com.example.demo.entity.Cumparatori;
import com.example.demo.exceptions.AlreadyExistsException;
import com.example.demo.exceptions.NotFoundError;
import com.example.demo.repository.ComenziRepository;
import com.example.demo.repository.CumparatoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CumparatoriService {
    @Autowired
    private CumparatoriRepository cumparatoriRepository;

    public List<Cumparatori> findAll() {
        return cumparatoriRepository.findAll();
    }

    public List<Cumparatori> findByCumparatorID(int cumparatorID) {
        if(!cumparatoriRepository.existById(cumparatorID)) {
            throw new NotFoundError(
                    "Not found with cumparatorID: " + cumparatorID);
        }
        return cumparatoriRepository.findByCumparatorID(cumparatorID);
    }

    public void createCumparator(Cumparatori cumparatori) {
        if(cumparatoriRepository.existById(cumparatori.getCumparatorID())) {
            throw new AlreadyExistsException(
                    "Already exist with cumparatorID: " + cumparatori.getCumparatorID());
        }

        cumparatoriRepository.createCumparator(cumparatori);
    }

    public void  updateCumparator(int cumparatorID, Cumparatori cumparatori) {
        cumparatoriRepository.updateCumparator(cumparatorID, cumparatori);
    }

    public void deleteCumparator(int cumparatorID) {
        cumparatoriRepository.deleteCumparator(cumparatorID);
    }
}
