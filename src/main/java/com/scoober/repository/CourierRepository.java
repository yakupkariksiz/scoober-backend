package com.scoober.repository;

import com.scoober.model.Courier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourierRepository extends MongoRepository<Courier, String> {
    
}
