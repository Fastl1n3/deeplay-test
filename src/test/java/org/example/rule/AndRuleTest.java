package org.example.rule;

import org.example.model.Animal;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AndRuleTest {

    @Test
    public void trueTestAndRule() {
        Animal animal = new Animal();
        animal.addProperty("ВЕС", "ЛЕГКОЕ");
        animal.addProperty("ТИП", "ТРАВОЯДНОЕ");
        Rule equalsRule1 = new EqualsRule("ТИП", "ТРАВОЯДНОЕ");
        Rule equalsRule2 = new EqualsRule("ВЕС", "ЛЕГКОЕ");
        Rule andRule = new AndRule(List.of(equalsRule1, equalsRule2));

        assertTrue(andRule.check(animal));
    }

    @Test
    public void falseTestAndRule() {
        Animal animal = new Animal();
        animal.addProperty("ВЕС", "ЛЕГКОЕ");
        animal.addProperty("ТИП", "ПЛОТОЯДНОЕ");
        Rule equalsRule1 = new EqualsRule("ТИП", "ТРАВОЯДНОЕ");
        Rule equalsRule2 = new EqualsRule("ВЕС", "ЛЕГКОЕ");
        Rule andRule = new AndRule(List.of(equalsRule1, equalsRule2));

        assertFalse(andRule.check(animal));
    }
}
