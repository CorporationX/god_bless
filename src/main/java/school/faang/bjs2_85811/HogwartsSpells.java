package school.faang.bjs2_85811;

import lombok.Getter;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    @Getter
    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    @Getter
    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private List<SpellEvent> allSpells = new ArrayList<>();

    void addSpellEvent(String eventType, String actionDescription) {
        if (eventType != null && actionDescription != null) {
            SpellEvent spell = new SpellEvent(eventType, actionDescription);
            allSpells.add(spell);
            spellById.put(spell.uniqueId(), spell);
            spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(spell);
        } else {
            throw new IllegalArgumentException("Event Type and Action Description cannot be null");
        }
    }

    SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    void deleteSpellEvent(int id) {
        SpellEvent spellToRemove = spellById.remove(id);
        if (spellToRemove != null) {
            allSpells.remove(spellToRemove);
            List<SpellEvent> spellsOfType = spellsByType.get(spellToRemove.getEventType());
            if (spellsOfType != null) {
                spellsOfType.remove(spellToRemove);
                if (spellsOfType.isEmpty()) {
                    spellsByType.remove(spellToRemove.getEventType());
                }
            }
        }
    }

    void printAllSpellEvents() throws UnsupportedEncodingException {
        for (Map.Entry<Integer, SpellEvent> e : spellById.entrySet()) {
            System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
            System.out.println("ID: " + e.getKey()
                    + ", Type: " + e.getValue().getEventType()
                    + ", Action: " + e.getValue().getAction());
        }
    }
}
