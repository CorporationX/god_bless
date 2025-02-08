package school.faang.sprint.first.catchevent.service;

import lombok.NonNull;
import school.faang.sprint.first.catchevent.model.SpellEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class HogwartsSpells {
    private static final AtomicInteger ID_COUNT = new AtomicInteger(1);
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(@NonNull String eventType, @NonNull String actionDescription) {
        if (eventType.isBlank() || actionDescription.isBlank()) {
            throw new IllegalArgumentException("eventType и actionDescription не могут быть пустыми");
        }

        int spellEventId = ID_COUNT.getAndIncrement();
        SpellEvent spellEventForAdd = new SpellEvent(spellEventId, eventType, actionDescription);

        spellById.put(spellEventId, spellEventForAdd);
        spellsByType.computeIfAbsent(eventType, spellEvents -> new ArrayList<>()).add(spellEventForAdd);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(@NonNull String eventType) {
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.get(id);
        if (spellEvent == null) {
            throw new IllegalArgumentException("SpellEvent c ID: " + id + " не найден");
        }

        spellsByType.get(spellEvent.getEventType())
                .removeIf(spell -> spell.getId() == id);

        spellById.remove(id);
    }

    public void printAllSpellEvents() {
        if (spellById.isEmpty()) {
            System.out.println("Пока никто и ничего не кастовал, заходите позже");
            return;
        }

        spellById.values().forEach(System.out::println);
    }
}
