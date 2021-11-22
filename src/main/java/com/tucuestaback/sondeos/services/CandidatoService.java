package com.tucuestaback.sondeos.services;

import java.util.List;

import com.tucuestaback.sondeos.models.CandidatoModel;
import com.tucuestaback.sondeos.repositories.CandidatoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatoService {
    
    @Autowired
    CandidatoRepository candidatoRepository;

    public void guardarCandidato(CandidatoModel candidato){
        this.candidatoRepository.save(candidato);
    }

    public List<CandidatoModel> obtenerCandidatos(){
        return this.candidatoRepository.findAll();
    }


}
