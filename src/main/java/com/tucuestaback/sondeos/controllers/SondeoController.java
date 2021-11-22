package com.tucuestaback.sondeos.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import com.tucuestaback.sondeos.models.SondeoModel;
import com.tucuestaback.sondeos.services.SondeoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SondeoController {

    @Autowired
    SondeoService service;

    @PostMapping("/sondeos")
    public ResponseEntity<Map<String, String>> guardar(@Valid @RequestBody SondeoModel sondeo) {
        this.service.guardarSondeo(sondeo);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Se agrego sondeo satisfactoriamente");
        respuesta.put("estado", "true");
        return ResponseEntity.ok(respuesta);
    }

}
