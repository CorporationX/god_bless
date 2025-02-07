package school.faang.catch_event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {

    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(eventType, actionDescription);
        spellById.put(spellEvent.getId(), spellEvent);
        spellsByType.putIfAbsent(spellEvent.getEventType(), new ArrayList<>());
        spellsByType.get(spellEvent.getEventType()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("id не может быть отрицательным");
        }
        if (!spellById.containsKey(id)) {
            throw new IllegalArgumentException("События с id %d не существует".formatted(id));
        }
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        if (eventType == null || eventType.isBlank()) {
            throw new IllegalArgumentException("Тип заклинания не может быть пустым или null");
        }

        List<SpellEvent> events = spellsByType.get(eventType);
        if (events == null) {
            throw new IllegalArgumentException("По данному типу заклинаний нет");
        }
        return events;
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = getSpellEventById(id);
        spellById.remove(id);
        spellsByType.remove(spellEvent.getEventType());
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.printf("id - %d, тип - %s, данные события - %s\n",
                    entry.getKey(), entry.getValue().getEventType(), entry.getValue());
        }
    }
}
