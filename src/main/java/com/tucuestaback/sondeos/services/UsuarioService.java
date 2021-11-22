package com.tucuestaback.sondeos.services;

import java.util.List;
import java.util.Optional;

import com.tucuestaback.sondeos.models.UsuarioModel;
import com.tucuestaback.sondeos.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public void guardarUsuario(UsuarioModel usuario){
        this.usuarioRepository.save(usuario);
    }

    public List<UsuarioModel> traerTodos(){
        return this.usuarioRepository.findAll();
    }

    public Optional<UsuarioModel> buscarPorId(String id){
        return this.usuarioRepository.findById(id);
    }

    public UsuarioModel buscarUsername(String username){
        return this.usuarioRepository.findByUsername(username).orElse(new UsuarioModel());
    }

}
