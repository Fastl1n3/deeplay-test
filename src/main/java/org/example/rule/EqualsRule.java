package org.example.rule;

import lombok.AllArgsConstructor;
import org.example.model.Animal;

@AllArgsConstructor
public class EqualsRule implements Rule {

    private String property;

    private String value;

    @Override
    public boolean check(Animal animal) {
        return animal.getProperty(property).equals(value);
    }
}
