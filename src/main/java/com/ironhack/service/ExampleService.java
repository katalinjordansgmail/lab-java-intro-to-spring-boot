package com.ironhack.service;

import com.ironhack.ironlibrary.model.Book;
import com.ironhack.ironlibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExampleService {
    @Autowired private ExampleRepository exampleRepository;

    public Optional<Example> searchExampleByName(String name) {
        return exampleRepository.findExampleByName(name);
    }

}
