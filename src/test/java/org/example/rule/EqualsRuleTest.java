package org.example.rule;

import org.example.model.Animal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EqualsRuleTest {

    @Test
    public void trueTestEqualsRule() {
        Animal animal = new Animal();
        animal.addProperty("ВЕС", "ЛЕГКОЕ");
        Rule rule = new EqualsRule("ВЕС", "ЛЕГКОЕ");
        assertTrue(rule.check(animal));
    }

    @Test
    public void falseTestEqualsRule() {
        Animal animal = new Animal();
        animal.addProperty("ВЕС", "ЛЕГКОЕ");
        Rule rule = new EqualsRule("ВЕС", "ТЯЖЕЛОЕ");
        assertFalse(rule.check(animal));
    }
}
