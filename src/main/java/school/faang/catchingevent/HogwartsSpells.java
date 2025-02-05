package school.faang.catchingevent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private int idCounter = 1;

    public void addSpellEvent(String eventType, String actionDescription) {
        int id = idCounter++;
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);
        System.out.println("Событие заклинания успешно добавлено: " + spellEvent.toString());
    }

    public SpellEvent getSpellEventById(int id) {
        SpellEvent spellEvent = spellById.get(id);
        if (spellEvent != null) {
            System.out.println("Найдено событие заклинания: " + spellEvent);
        } else {
            System.out.println("Событие заклинания с ID=" + id + " не найдено.");
        }
        return spellEvent;
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        List<SpellEvent> events = spellsByType.get(eventType);
        if (events != null && !events.isEmpty()) {
            System.out.println("Найдено событие(-я) заклинания по типу '" + eventType + "':");
            for (SpellEvent event : events) {
                System.out.println(event);
            }
        } else {
            System.out.println("События заклинаний по типу '" + eventType + "' не найдены.");
        }
        return events;
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.get(id);
        if (spellEvent != null) {
            spellById.remove(id);
            List<SpellEvent> eventsByType = spellsByType.get(spellEvent.getEventType());
            if (eventsByType != null) {
                eventsByType.remove(spellEvent);
                if (eventsByType.isEmpty()) {
                    spellsByType.remove(spellEvent.getEventType());
                }
            }
            System.out.println("Событие заклинания с ID=" + id + " успешно удалено.");
        } else {
            System.out.println("Событие заклинания с ID=" + id + " не найдено.");
        }
    }

    public void printAllSpellEvents() {
        System.out.println("Все события заклинаний:");
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
