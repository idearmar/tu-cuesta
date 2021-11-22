package com.tucuestaback.sondeos.repositories;

import com.tucuestaback.sondeos.models.SondeoModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SondeoRepository extends MongoRepository<SondeoModel, String> {
    
}
