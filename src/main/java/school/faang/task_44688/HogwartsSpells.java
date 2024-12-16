package school.faang.task_44688;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    protected void addSpellEvent(String eventType, String actionDescription) {
        if (eventType == null || eventType.isBlank()) {
            throw new IllegalArgumentException("Event type cannot be null or blank");
        }

        if (actionDescription == null || actionDescription.isBlank()) {
            throw new IllegalArgumentException("ActionDescription cannot be null or blank");
        }

        SpellEvent spell = new SpellEvent(eventType, actionDescription);

        spellById.put(spell.getId(), spell);
        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(spell);

        System.out.println("Added event " + eventType + " with description " + actionDescription);
    }

    protected SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    protected List<SpellEvent> getSpellEventsByType(String eventType) {
        if (!spellsByType.containsKey(eventType)) {
            throw new IllegalArgumentException("Event type " + eventType + " not found");
        }

        return spellsByType.get(eventType);
    }

    protected void deleteSpellEvent(int id) {
        if (!spellById.containsKey(id)) {
            throw new IllegalArgumentException("Event id " + id + " not found");
        }

        System.out.println("\nDelete event by id: " + id);

        SpellEvent deleteSpell = spellById.get(id);
        String eventType = deleteSpell.getEventType();

        spellById.remove(id);
        spellsByType.get(eventType).remove(deleteSpell);

        System.out.println("Deleted event " + deleteSpell);

        if (spellsByType.get(eventType).isEmpty()) {
            spellsByType.remove(eventType);
        }
    }

    protected void printAllSpellEvents() {
        if (spellById.isEmpty()) {
            throw new IllegalStateException("No spells found. The collection is empty.");
        }

        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    protected void printSpellEvents() {
        spellById.forEach((id, spell) -> System.out.println(spell));
    }

    protected void printSpellEventsByType() {
        spellsByType.forEach((type, spells) -> {
            System.out.println("Spell type: " + type);
            spells.forEach(System.out::println);
        });
    }
}