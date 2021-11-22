package com.tucuestaback.sondeos.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import com.tucuestaback.sondeos.models.UsuarioModel;
import com.tucuestaback.sondeos.services.UsuarioService;
import com.tucuestaback.sondeos.utils.BCrypt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/usuarios")
    public ResponseEntity<Map<String,String>> guardar(@Valid @RequestBody UsuarioModel usuario){
        Map<String,String> respuesta=new HashMap<>();

        usuario.setPassword(BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt()));

        UsuarioModel u=this.usuarioService.buscarUsername(usuario.getUsername());

        if(u.getId()==null){
            this.usuarioService.guardarUsuario(usuario);
            respuesta.put("mensaje", "Se agregó usuario satisfactoriamente");
        }else{
            respuesta.put("mensaje", "el usuario ya esta registrado");
        }
        return ResponseEntity.ok(respuesta);
    }
}
