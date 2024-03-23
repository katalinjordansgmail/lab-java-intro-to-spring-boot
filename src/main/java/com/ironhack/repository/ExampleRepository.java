package com.ironhack.repository;

import com.ironhack.ironlibrary.model.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExampleRepository extends JpaRepository<Example, Integer> {

    Optional<Example> findExampleByName(String name);

}
