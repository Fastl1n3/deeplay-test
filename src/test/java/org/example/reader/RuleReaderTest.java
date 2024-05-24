package org.example.reader;

import org.example.rule.AndRule;
import org.example.rule.EqualsRule;
import org.example.rule.Rule;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RuleReaderTest {

    @Test
    public void testLoadRules() throws IOException {
        RuleReader ruleReader = new RuleReader();
        List<Rule> rules = ruleReader.readRules(new FileReader("src/test/resources/rules.json"));

        assertEquals(3, rules.size());

        assertTrue(rules.get(0) instanceof EqualsRule);

        assertTrue(rules.get(1) instanceof AndRule);

        assertTrue(rules.get(2) instanceof AndRule);

    }
}
