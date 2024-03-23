package com.ironhack.repository;

import com.ironhack.ironlibrary.model.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExampleRepositoryTest {

    @Autowired
    private ExampleRepository exampleRepository;

    @BeforeEach
    void setUp() {
        List<Example> examples = List.of(
                new Example("Example 1", "ABC159753"),
                new Example("Example 2", "DEF159753"),
        );
        exampleRepository.saveAll(examples);
    }

    @AfterEach
    void tearDown() {
        exampleRepository.deleteAll();
        exampleRepository.flush();
    }

    @Test
    public void testExampleByName() {
        Optional<Example> example = exampleRepository.findExampleByName("Example 1");
        assertFalse(example.isPresent());
    }

}