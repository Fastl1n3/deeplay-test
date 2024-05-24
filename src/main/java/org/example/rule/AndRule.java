package org.example.rule;

import lombok.AllArgsConstructor;
import org.example.model.Animal;

import java.util.List;

@AllArgsConstructor
public class AndRule implements Rule {

    private final List<Rule> subRules;

    @Override
    public boolean check(Animal animal) {
        for (Rule rule: subRules) {
            if (!rule.check(animal)) {
                return false;
            }
        }
        return true;
    }
}
