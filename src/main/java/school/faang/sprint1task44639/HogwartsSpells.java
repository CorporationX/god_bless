package school.faang.sprint1task44639;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    Map<Integer, SpellEvent> spellById = new HashMap<>();
    Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);

        spellById.put(id, spellEvent);
        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        SpellEvent event = spellById.get(id);
        if (event == null) {
            throw new IllegalArgumentException("Событие с ID " + id + " не найдено.");
        }

        return event;
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        List<SpellEvent> type = spellsByType.get(eventType);
        if (type == null) {
            throw new IllegalArgumentException("Событие с Type '" + eventType + "' не найдено.");
        }

        return type;
    }

    public void deleteSpellEvent(int id) {
        if (!spellById.containsKey(id)) {
            System.out.println("Событие с ID " + id + " не найдено.");
            return;
        }

        SpellEvent event = spellById.get(id);

        spellById.remove(id);

        List<SpellEvent> events = spellsByType.get(event.eventType);

        if (events != null) {
            events.remove(event);

            if (events.isEmpty()) {
                spellsByType.remove(event.eventType);
            }
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
