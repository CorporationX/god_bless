package school.faang.bjs2_69898;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private int innerId = 1;

    public void addSpellEvent(String eventType, String actionDescription) {
        EventType type;
        try {
            type = EventType.valueOf(eventType);
        } catch (IllegalArgumentException e) {
            System.out.println("Неизвестный тип заклинания: " + eventType);
            return;
        }

        var event = new SpellEvent(type, actionDescription);
        spellById.put(innerId, event);

        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(event);
        innerId++;
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, Collections.emptyList());
    }

    public void deleteSpellEvent(int id) {
        var removedSpell = spellById.remove(id);
        if (removedSpell == null) {
            System.out.println("Событие с ID " + id + " не найдено");
            return;
        }

        var spellEvents = spellsByType.get(removedSpell.getEventType().name());
        if (spellEvents != null) {
            spellEvents.remove(removedSpell);
        }
    }

    public void printAllSpellEvents() {
        for (var entry : spellById.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", " + entry.getValue());
        }
    }
}