package com.example.demo.service;

import com.example.demo.entity.Cumparatori;
import com.example.demo.entity.Produs;
import com.example.demo.exceptions.AlreadyExistsException;
import com.example.demo.exceptions.NotFoundError;
import com.example.demo.repository.ProdusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdusService {
    @Autowired
    private ProdusRepository produsRepository;

    public List<Produs> findAll() {
        return produsRepository.findAll();
    }

    public List<Produs> findByCodProdus(int codProdus) {
        if(!produsRepository.existBycodProdus(codProdus)) {
            throw new NotFoundError(
                    "Not found with codProdus: " + codProdus);
        }
        return produsRepository.findByCodProdus(codProdus);
    }

    public void createProdus(Produs produs) {
        if(produsRepository.existBycodProdus(produs.getCodProdus())) {
            throw new AlreadyExistsException(
                    "Already exist with codProdus: " + produs.getCodProdus());
        }

        produsRepository.createProdus(produs);
    }

    public void  updateProdus(int codProdus, Produs produs) {
        produsRepository.updateProdus(codProdus, produs);
    }

    public void deleteProdus(int codProdus) {
        produsRepository.deleteProdus(codProdus);
    }
}
