package org.example.handler;

import org.example.model.Animal;
import org.example.rule.EqualsRule;
import org.example.rule.Rule;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalRulesHandlerTest {

    @Test
    public void testCountAnimalByRule() {
        AnimalRulesHandler animalRulesHandler = new AnimalRulesHandler();
        Rule rule = new EqualsRule("ТИП", "ТРАВОЯДНОЕ");

        HashMap<String, String> properties1 = new HashMap<>();
        properties1.put("ТИП", "ТРАВОЯДНОЕ");
        HashMap<String, String> properties2 = new HashMap<>();
        properties2.put("ТИП", "ПЛОТОЯДНОЕ");

        List<Animal> animals = List.of(new Animal(properties1), new Animal(properties2));


        int count = animalRulesHandler.countAnimalByRule(animals, rule);
        assertEquals(1, count);
    }

}
