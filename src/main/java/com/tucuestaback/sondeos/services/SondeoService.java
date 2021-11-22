package com.tucuestaback.sondeos.services;

import com.tucuestaback.sondeos.models.SondeoModel;
import com.tucuestaback.sondeos.repositories.SondeoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SondeoService {

    @Autowired
    SondeoRepository sondeoRepository;

    public void guardarSondeo(SondeoModel sondeo) {
        this.sondeoRepository.save(sondeo);
    }

}
