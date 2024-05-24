package org.example.factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.example.rule.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class RuleFactoryTest {

    private final ObjectMapper mapper = new ObjectMapper();

    private ObjectNode subRule1;

    private ObjectNode subRule2;


    @BeforeEach
    public void init() {

        subRule1 = mapper.createObjectNode();
        subRule1.put("rule", "equals");
        subRule1.put("property", "ТИП");
        subRule1.put("value", "ТРАВОЯДНОЕ");

        subRule2 = mapper.createObjectNode();
        subRule2.put("rule", "equals");
        subRule2.put("property", "РОСТ");
        subRule2.put("value", "МАЛЕНЬКОЕ");
    }

    @Test
    public void testCreateEqualsRule() throws IOException {
        RuleFactory factory = new RuleFactory();
        Rule rule = factory.create(subRule1);
        assertNotNull(rule);
        assertTrue(rule instanceof EqualsRule);
    }

    @Test
    public void testCreateAndRule() throws IOException {
        ObjectNode node = mapper.createObjectNode();
        node.put("rule", "and");
        node.set("subRules", mapper.createArrayNode().add(subRule1).add(subRule2));

        RuleFactory factory = new RuleFactory();
        Rule rule = factory.create(node);
        assertNotNull(rule);
        assertTrue(rule instanceof AndRule);
    }

    @Test
    public void testCreateOrRule() throws IOException {
        ObjectNode node = mapper.createObjectNode();
        node.put("rule", "or");
        node.set("subRules", mapper.createArrayNode().add(subRule1).add(subRule2));

        RuleFactory factory = new RuleFactory();
        Rule rule = factory.create(node);
        assertNotNull(rule);
        assertTrue(rule instanceof OrRule);
    }

    @Test
    public void testCreateNotRule() throws IOException {
        ObjectNode node = mapper.createObjectNode();
        node.put("rule", "not");
        node.set("subRules", subRule1);

        RuleFactory factory = new RuleFactory();
        Rule rule = factory.create(node);
        assertNotNull(rule);
        assertTrue(rule instanceof NotRule);
    }

    @Test
    public void testUnknownRule() {
        ObjectNode node = mapper.createObjectNode();
        node.put("rule", "new");

        RuleFactory factory = new RuleFactory();

        assertThrows(IOException.class,() -> factory.create(node));
    }
}