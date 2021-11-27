package com.tucuestaback.sondeos.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.tucuestaback.sondeos.exceptions.CustomException;
import com.tucuestaback.sondeos.models.CandidatoModel;
import com.tucuestaback.sondeos.services.CandidatoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CandidatoController {

    @Autowired
    CandidatoService candidatoService;

    @PostMapping("/candidatos")
    public ResponseEntity<Map<String,String>> guardar(@Valid @RequestBody CandidatoModel candidato){
        this.candidatoService.guardarCandidato(candidato);
        Map<String, String> respuesta=new HashMap<>();
        respuesta.put("mensaje", "Se agrego candidato satisfactoriamente");
        respuesta.put("estado", "true");
        return ResponseEntity.ok(respuesta);
    }
    @GetMapping("/candidatos")
    public List<CandidatoModel> mostrar(){
        return candidatoService.obtenerCandidatos();
    }

    public void throwError(Errors error){
        String mensaje="";
        int index=0;

        for(ObjectError e: error.getAllErrors()){
            if(index>0){
                mensaje +=" | ";
            }
            mensaje+=String.format("Parametro: %s - Mensaje: %s", e.getObjectName(),e.getDefaultMessage());
        }
        throw new CustomException(mensaje);
    }
}
