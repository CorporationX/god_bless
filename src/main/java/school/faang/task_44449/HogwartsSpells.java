package school.faang.task_44449;

import java.util.*;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(Integer id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(Integer id) {
        return Optional.ofNullable(spellById.get(id))
                .orElseThrow(() -> new IllegalArgumentException("Событие по id: " + id + " не найдено"));
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
