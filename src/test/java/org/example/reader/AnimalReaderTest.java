package org.example.reader;

import org.example.model.Animal;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalReaderTest {

    @Test
    public void testReadAnimals() throws IOException {
        AnimalReader animalReader = new AnimalReader();
        List<Animal> animals = animalReader.readAnimals(new FileReader("src/test/resources/animals.json"));

        assertEquals(5, animals.size());

        Animal animal = animals.get(0);
        assertEquals("ЛЕГКОЕ", animal.getProperty("ВЕС"));
        assertEquals("МАЛЕНЬКОЕ", animal.getProperty("РОСТ"));
        assertEquals("ВСЕЯДНОЕ", animal.getProperty("ТИП"));

    }
}
