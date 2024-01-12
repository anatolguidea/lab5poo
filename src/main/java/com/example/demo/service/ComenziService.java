package com.example.demo.service;

import com.example.demo.entity.Comenzi;
import com.example.demo.exceptions.AlreadyExistsException;
import com.example.demo.exceptions.NotFoundError;
import com.example.demo.repository.ComenziRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ComenziService {
    @Autowired
    private ComenziRepository comenziRepository;
    public List<Comenzi> findAll() {
        return comenziRepository.findAll();
    }

    public List<Comenzi> findByCumparatorID(int cumparatorID) {
        if(!comenziRepository.existByIdCumparator(cumparatorID)) {
            throw new NotFoundError(
                    "Not found with comandaID: " + cumparatorID);
        }
        return comenziRepository.findByCumparatorID(cumparatorID);
    }

    public List<Comenzi> findByComandaID(int comandaID) {
        if(!comenziRepository.existById(comandaID)) {
            throw new NotFoundError(
                    "Not found with comandaID: " + comandaID);
        }
        return comenziRepository.findByComandaID(comandaID);
    }

    public void createComanda(Comenzi comenzi) {
        if(comenziRepository.existById(comenzi.getComandaID())) {
            throw new AlreadyExistsException(
                    "Already exist with comandaID: " + comenzi.getComandaID());
        }

        comenziRepository.createComanda(comenzi);
    }

    public void  updateComanda(int comandaID, Comenzi comenzi) {
        comenziRepository.updateComanda(comandaID, comenzi);
    }

    public void deleteComanda(int comandaID) {
        comenziRepository.deleteComanda(comandaID);
    }
}
