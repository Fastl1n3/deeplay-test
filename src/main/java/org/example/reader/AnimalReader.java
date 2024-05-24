package org.example.reader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Animal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnimalReader {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Animal> readAnimals(Reader reader) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(reader)) {

            List<Animal> animals = new ArrayList<>();
            JsonNode root = objectMapper.readTree(bufferedReader);
            for (JsonNode node : root) {
                HashMap<String, String> properties = objectMapper.convertValue(node, new TypeReference<>() {
                });
                animals.add(new Animal(properties));
            }
            return animals;
        }
    }
}
