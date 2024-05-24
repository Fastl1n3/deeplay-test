package org.example.rule;

import org.example.model.Animal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NotRuleTest {

    @Test
    public void trueTestNotRule() {
        Animal animal = new Animal();
        animal.addProperty("ТИП", "ТРАВОЯДНОЕ");

        Rule rule = new EqualsRule("ТИП", "ВСЕЯДНОЕ");

        NotRule notRule = new NotRule(rule);

        assertTrue(notRule.check(animal));

        Animal herbivoreAnimal = new Animal();
        herbivoreAnimal.addProperty("ТИП", "ТРАВОЯДНОЕ");

        assertTrue(notRule.check(herbivoreAnimal));
    }

    @Test
    public void falseTestNotRule() {
        Animal animal = new Animal();
        animal.addProperty("ТИП", "ТРАВОЯДНОЕ");

        Rule rule = new EqualsRule("ТИП", "ТРАВОЯДНОЕ");

        NotRule notRule = new NotRule(rule);

        assertFalse(notRule.check(animal));
    }
}
