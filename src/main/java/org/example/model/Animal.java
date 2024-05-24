package org.example.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
public class Animal {

    private HashMap<String, String> properties = new HashMap<>();

    public void addProperty(String key, String value) {
        properties.put(key, value);
    }

    public String getProperty(String key) {
        return properties.getOrDefault(key, "");
    }
}
