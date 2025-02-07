package school.faang.bjs2_57067;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {

    private static final String EVENT_DOESNT_EXISTS_TEMPLATE = "События с id %d не существует";

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

        SpellEvent event = spellById.get(id);
        nullCheck(event, EVENT_DOESNT_EXISTS_TEMPLATE.formatted(id));
        return event;
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        if (eventType == null || eventType.isBlank()) {
            throw new IllegalArgumentException("Тип заклинания не может быть пустым или null");
        }
        List<SpellEvent> events = spellsByType.get(eventType);
        String errorMessage = "По данному типу заклинаний нет";
        nullCheck(events, errorMessage);
        return events;
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        nullCheck(spellEvent, EVENT_DOESNT_EXISTS_TEMPLATE.formatted(id));
        List<SpellEvent> events = spellsByType.get(spellEvent.getEventType());
        events.remove(spellEvent);
        if (events.isEmpty()) {
            spellsByType.remove(spellEvent.getEventType());
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.printf("id - %d, тип - %s, данные события - %s\n",
                    entry.getKey(), entry.getValue().getEventType(), entry.getValue().getAction());
        }
    }

    private void nullCheck(Object obj, String errorMessage) {
        if (obj == null) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
