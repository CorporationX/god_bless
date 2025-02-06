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
    private int idGenerator;
    private final Map<Integer, SpellEvent> spellsOnId = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        if (eventType == null || eventType.isEmpty()) {
            throw new IllegalArgumentException("Не валидное заначение eventType : " + eventType);
        }
        if (actionDescription == null || actionDescription.isEmpty()) {
            throw new IllegalArgumentException("Не валидное заначение actionDescription : " + actionDescription);
        }

        int id = idGenerator++;
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);

        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);


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
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public void deleteSpellEvent(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("id не должен быть меньше 0");
        }
        SpellEvent spellEvent = spellsOnId.get(id);
        spellsOnId.remove(id);
        spellsByType.get(spellEvent.getEventType()).remove(spellEvent);

    }

    public void printAllSpellEvents() {
        spellsOnId.values().forEach(System.out::println);
    }

}
