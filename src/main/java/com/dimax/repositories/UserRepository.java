package com.dimax.repositories;


import com.dimax.entities.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntity, String> {

    Page<UserEntity> findAll(Pageable pageable);
}
