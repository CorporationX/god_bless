package school.faang.task_44449;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById;
    private final Map<String, List<SpellEvent>> spellsByType;

    public HogwartsSpells() {
        spellById = new HashMap<>();
        spellsByType = new HashMap<>();
    }

    public void addSpellEvent(Integer id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(Integer id) {
        var spellEvent = spellById.get(id);
        if (spellEvent == null) {
            throw new IllegalArgumentException("Событие по id: " + id + " не найдено");
        }
        return spellEvent;
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public void deleteSpellEvent(Integer id) {
        var spellEvent = spellById.remove(id);
        if (spellEvent == null) {
            throw new IllegalArgumentException("Событие по id: " + id + " не найдено");
        }

        List<SpellEvent> events = spellsByType.get(spellEvent.getEventType());
        if (events == null) {
            throw new IllegalArgumentException("События по типу заклинания: "
                    + spellEvent.getEventType() + " не найдены");
        }
        events.remove(spellEvent);
        if (events.isEmpty()) {
            spellsByType.remove(spellEvent.getEventType());
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println("ID: " + entry.getKey()
                    + ", Тип заклинания: " + entry.getValue().getEventType()
                    + ", Описание: " + entry.getValue().getAction());
        }
    }
}
