package school.faang.sprint1.task_BJS2_57050;

/**
 * File for test:
 * test/java/school/faang/sprint1/task_BJS2_57050/HogwartsSpellsTest
 */

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class HogwartsSpells {
    private final AtomicInteger idGenerator = new AtomicInteger();
    private final Map<Integer, SpellEvent> spellsOnId = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private final Map<String, Map<SpellEvent, Integer>> idsSpellInSpellsByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        if (eventType == null || eventType.isEmpty()) {
            throw new IllegalArgumentException("Не валидное заначение eventType : " + eventType);
        }
        if (actionDescription == null || actionDescription.isEmpty()) {
            throw new IllegalArgumentException("Не валидное заначение actionDescription : " + actionDescription);
        }

        int idSpellInSpellsByType;
        int id = idGenerator.getAndIncrement();
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);

        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>());
        List<SpellEvent> spellEvents = spellsByType.get(eventType);
        idSpellInSpellsByType = spellEvents.size();
        spellEvents.add(spellEvent);

        idsSpellInSpellsByType.computeIfAbsent(eventType, k -> new HashMap<>());
        idsSpellInSpellsByType.get(eventType).put(spellEvent, idSpellInSpellsByType);

        spellsOnId.put(id, spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("id не должен быть меньше 0");
        }
        return spellsOnId.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        if (eventType == null || eventType.isEmpty()) {
            throw new IllegalArgumentException("Не валидное заначение eventType : " + eventType);
        }
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("id не должен быть меньше 0");
        }
        int idSpellInSpellsByType;

        SpellEvent spellEvent = spellsOnId.get(id);
        spellsOnId.remove(id);

        idSpellInSpellsByType = idsSpellInSpellsByType.get(spellEvent.eventType).get(spellEvent);
        idsSpellInSpellsByType.get(spellEvent.eventType).remove(spellEvent);

        spellsByType.get(spellEvent.eventType).remove(idSpellInSpellsByType);

    }

    public void printAllSpellEvents() {
        spellsOnId.forEach((id, spellEvent) -> System.out.println(spellEvent));
    }

    @AllArgsConstructor
    @ToString
    private class SpellEvent {
        private int id;
        private String eventType;
        private String action;
    }
}
