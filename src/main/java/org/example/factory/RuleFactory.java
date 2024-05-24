package org.example.factory;

import com.fasterxml.jackson.databind.JsonNode;
import org.example.rule.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RuleFactory {

    public Rule create(JsonNode node) throws IOException {
        String ruleName = node.get("rule").asText();

        switch (ruleName) {
            case "equals" -> {
                return new EqualsRule(node.get("property").asText(), node.get("value").asText());
            }
            case "not" -> {
                return new NotRule(create(node.get("subRules")));
            }
            case "and" -> {
                List<Rule> rules = new ArrayList<>();
                for (JsonNode rule : node.get("subRules")) {
                    rules.add(create(rule));
                }
                return new AndRule(rules);
            }
            case "or" -> {
                List<Rule> rules = new ArrayList<>();
                for (JsonNode rule : node.get("subRules")) {
                    rules.add(create(rule));
                }
                return new OrRule(rules);
            }
            default -> throw new IOException("Unknown rule: " + ruleName);
        }
    }
}
