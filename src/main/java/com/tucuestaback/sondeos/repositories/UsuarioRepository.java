package com.tucuestaback.sondeos.repositories;

import java.util.Optional;

import com.tucuestaback.sondeos.models.UsuarioModel;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<UsuarioModel, String> {

    public Optional<UsuarioModel> findByUsername(String username);
}
