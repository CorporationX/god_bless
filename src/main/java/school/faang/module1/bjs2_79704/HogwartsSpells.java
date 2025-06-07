package school.faang.module1.bjs2_79704;

import java.util.*;

public class HogwartsSpells {

    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private int currentId = 0;

    public void addSpellEvent(String eventType, String actionDescription) {
        if (eventType == null) {
            throw new IllegalArgumentException("eventType не может быть null");
        }
        if (actionDescription == null) {
            throw new IllegalArgumentException("actionDescription не может быть null");
        }
        int id = generateUniqueId();
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        spellsByType.computeIfAbsent(eventType, e -> new ArrayList<>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, Collections.emptyList());
    }

    public SpellEvent deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent == null) {
            return null;
        }
        List<SpellEvent> events = spellsByType.get(spellEvent.getEventType());
        if (events == null || !events.remove(spellEvent)) {
            return null;
        }
        if (events.isEmpty()) {
            spellsByType.remove(spellEvent.getEventType());
        }
        return spellEvent;
    }

    public void printAllSpellEvents() {
        for (SpellEvent spellEvent : spellById.values()) {
            System.out.println(spellEvent);
        }
    }

    private int generateUniqueId() {
        return ++currentId;
    }
}