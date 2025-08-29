package com.crio.coderhack.Repository;

import com.crio.coderhack.Model.Model;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<Model, String> {
}
