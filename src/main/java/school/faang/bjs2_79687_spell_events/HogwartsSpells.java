package school.faang.bjs2_79687_spell_events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private static final HashMap<Integer, SpellEvent> spellById = new HashMap<>();
    private static final HashMap<String, List<SpellEvent>> spellsByType = new HashMap<>();
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
            System.out.println("Deleted spell with id " + id + " from id registry.");
            deleteSpellFromTypesRegistry(deletedSpell);
        }
    }

    private static void deleteSpellFromTypesRegistry(SpellEvent spell) {
        if (spellsByType.get(spell.getEventType()) != null) {
            if (spellsByType.get(spell.getEventType()).remove(spell)) {
                System.out.println("Deleted spell with id " + spell.getId() + " from types registry.");
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