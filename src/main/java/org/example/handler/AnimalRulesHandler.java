package org.example.handler;

import org.example.model.Animal;
import org.example.rule.Rule;

import java.util.List;

public class AnimalRulesHandler {

    public int countAnimalByRule(List<Animal> animals, Rule rule) {
        int count = 0;
        for(Animal animal : animals) {
            if (rule.check(animal)) {
                count++;
            }
        }
        return count;
    }
}
