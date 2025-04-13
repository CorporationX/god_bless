package school.faang.catchevents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class HogwartsSpells {

    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<EventType, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(EventType eventType, String actionDescription) {
        int id = IdGlobalProvider.getId();
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);

        spellById.put(id, spellEvent);
        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        SpellEvent event = spellById.get(id);
        if (event == null) {
            throw new NoSuchElementException("Событие заклинания отсутствует");
        }
        return event;
    }

    public List<SpellEvent> getSpellEventsByType(EventType eventType) {
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent == null) {
            throw new NoSuchElementException("Событие заклинания отсутствует");
        }
        EventType eventType = spellEvent.getEventType();
        if (eventType == null) {
            throw new NoSuchElementException("Тип заклинания отсутствует");
        }
        List<SpellEvent> events = spellsByType.get(spellEvent.getEventType());
        events.remove(spellEvent);
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}