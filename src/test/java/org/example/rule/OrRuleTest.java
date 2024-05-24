package org.example.rule;

import org.example.model.Animal;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrRuleTest {
    @Test
    public void trueTestOrRule() {
        Animal animal = new Animal();
        animal.addProperty("ТИП", "ТРАВОЯДНОЕ");

        Rule equalsRule1 = new EqualsRule("ТИП", "ТРАВОЯДНОЕ");
        Rule equalsRule2 = new EqualsRule("ТИП", "ПЛОТОЯДНОЕ");

        OrRule orRule = new OrRule(List.of(equalsRule1, equalsRule2));

        assertTrue(orRule.check(animal));
    }

    @Test
    public void falseTestOrRule() {
        Animal animal = new Animal();
        animal.addProperty("ТИП", "ВСЕЯДНОЕ");

        Rule equalsRule1 = new EqualsRule("ТИП", "ТРАВОЯДНОЕ");
        Rule equalsRule2 = new EqualsRule("ТИП", "ПЛОТОЯДНОЕ");

        OrRule orRule = new OrRule(List.of(equalsRule1, equalsRule2));

        assertFalse(orRule.check(animal));
    }
}
