package org.example;

import org.example.handler.AnimalRulesHandler;
import org.example.model.Animal;
import org.example.reader.AnimalReader;
import org.example.reader.RuleReader;
import org.example.rule.Rule;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    public void mainTest() throws IOException {
        AnimalReader animalReader = new AnimalReader();
        List<Animal> animals = animalReader.readAnimals(new FileReader("src/test/resources/animals.json"));

        RuleReader ruleReader = new RuleReader();
        List<Rule> rules = ruleReader.readRules(new FileReader("src/test/resources/rules.json"));

        AnimalRulesHandler animalRulesHandler = new AnimalRulesHandler();
        int[] expectedValues = {2, 2, 1};
        int i = 0;
        for (Rule rule : rules) {
            assertEquals(expectedValues[i], animalRulesHandler.countAnimalByRule(animals, rule));
            i++;
        }
    }


}
