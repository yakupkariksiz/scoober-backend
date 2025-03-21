package com.scoober.repository;

import com.scoober.model.Courier;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourierRepository extends MongoRepository<Courier, String> {
    
}
