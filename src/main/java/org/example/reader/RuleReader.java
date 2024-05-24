package org.example.reader;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.factory.RuleFactory;
import org.example.rule.Rule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class RuleReader {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final RuleFactory ruleFactory = new RuleFactory();


    public List<Rule> readRules(Reader reader) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(reader)) {

            List<Rule> rules = new ArrayList<>();
            JsonNode root = objectMapper.readTree(bufferedReader);
            for (JsonNode node : root) {
                rules.add(ruleFactory.create(node));
            }
            bufferedReader.close();
            return rules;
        }
    }
}
