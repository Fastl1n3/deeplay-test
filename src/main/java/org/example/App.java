package org.example;


import org.example.handler.AnimalRulesHandler;
import org.example.model.Animal;
import org.example.reader.AnimalReader;
import org.example.reader.RuleReader;
import org.example.rule.Rule;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) {
        try {
            AnimalReader animalReader = new AnimalReader();
            List<Animal> animals = animalReader.readAnimals(new FileReader("src/main/resources/animals.json"));

            RuleReader ruleReader = new RuleReader();
            List<Rule> rules = ruleReader.readRules(new FileReader("src/main/resources/rules.json"));

            AnimalRulesHandler animalRulesHandler = new AnimalRulesHandler();
            for (Rule rule : rules) {
                System.out.println(animalRulesHandler.countAnimalByRule(animals, rule));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
