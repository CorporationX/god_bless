package school.faang.bjs2_79687_spell_events;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class HogwartsSpells {
    private static final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private static final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private static int lastId = 0;

    public static SpellEvent addSpellEvent(String eventType, String actionDescription) {
        if (eventType == null || eventType.isEmpty()) {
            throw new IllegalArgumentException("eventType cannot be empty or null.");
        }
        if (actionDescription == null || actionDescription.isEmpty()) {
            throw new IllegalArgumentException("actionDescription cannot be empty or null.");
        }

        SpellEvent newSpell = new SpellEvent(generateId(), eventType, actionDescription);
        registerSpell(newSpell);

        return newSpell;
    }

    private static int generateId() {
        return lastId++;
    }

    private static void registerSpell(SpellEvent spell) {
        if (spell == null) {
            throw new IllegalArgumentException("Cannot add null spell");
        }
        spellById.put(spell.getId(), spell);
        spellsByType.computeIfAbsent(spell.getEventType(), k -> new ArrayList<>()).add(spell);
    }

    public static SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public static List<SpellEvent> getSpellEventsByType(String eventType) {
        if (eventType == null) {
            throw new IllegalArgumentException("Cannot get spell list for type null");
        }

        return spellsByType.get(eventType) == null ? new ArrayList<>() : spellsByType.get(eventType);
    }

    public static void deleteSpellEvent(int id) {
        SpellEvent deletedSpell = spellById.remove(id);
        if (deletedSpell != null) {
            log.info("Deleted spell with id {} from id registry.", id);
            deleteSpellFromTypesRegistry(deletedSpell);
        }
    }

    private static void deleteSpellFromTypesRegistry(SpellEvent spell) {
        if (spellsByType.get(spell.getEventType()) != null) {
            if (spellsByType.get(spell.getEventType()).remove(spell)) {
                log.info("Deleted spell with id {} from types registry.", spell.getId());
            }
        }
    }

    public static void printAllSpellEvents() {
        System.out.println("\n- Printing all spells in id registry -");
        for (Map.Entry<Integer, SpellEvent> spell : spellById.entrySet()) {
            System.out.println(spell.getValue());
        }
    }

}