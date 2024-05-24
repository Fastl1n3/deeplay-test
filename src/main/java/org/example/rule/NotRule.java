package org.example.rule;

import lombok.AllArgsConstructor;
import org.example.model.Animal;

@AllArgsConstructor
public class NotRule implements Rule {

    private final Rule subRule;

    @Override
    public boolean check(Animal animal) {
        return !subRule.check(animal);
    }


}
