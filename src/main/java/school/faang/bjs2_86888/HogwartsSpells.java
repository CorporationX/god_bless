package school.faang.bjs2_86888;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {

    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private int id = 1;

    public void addSpellEvent(String eventType, String actionDescription) {
        validateEventType(eventType);
        validateAction(actionDescription);

        SpellEvent spellEvent = new SpellEvent(id++, eventType, actionDescription);

        spellById.put(spellEvent.getId(), spellEvent);
        spellsByType.computeIfAbsent(spellEvent.getEventType(), k -> new ArrayList<>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        validateId(id);
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        validateEventType(eventType);
        return new ArrayList<>(spellsByType.getOrDefault(eventType, Collections.emptyList()));
    }

    public void deleteSpellEvent(int id) {
        validateId(id);
        SpellEvent removed = spellById.remove(id);

        if (removed != null) {
            List<SpellEvent> events = spellsByType.get(removed.getEventType());
            if (events != null) {
                events.remove(removed);
                if (events.isEmpty()) {
                    spellsByType.remove(removed.getEventType());
                }
            }
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.printf("ID события: %s%nТип события: %s%nДанные события: %s%n",
                    entry.getKey(), entry.getValue().getEventType(), entry.getValue().getAction());
        }
    }

    private void validateId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id должен быть положительным числом.");
        }
    }

    private void validateEventType(String eventType) {
        if (eventType == null || eventType.isBlank()) {
            throw new IllegalArgumentException("Тип заклинания не может быть null или пустым.");
        }
    }

    private void validateAction(String actionDescription) {
        if (actionDescription == null || actionDescription.isBlank()) {
            throw new IllegalArgumentException("Описание заклинания не может быть null или пустым.");
        }
    }
}