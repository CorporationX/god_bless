package school.faang.sprint1.task_44656;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {

    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(spellEvent.getId(), spellEvent);
        spellsByType.put(spellEvent.getEventType(), new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        SpellEvent spellEvent = spellById.get(id);
        if (spellEvent != null) {
            return spellById.get(id);
        } else {
            System.out.println("Заклинание не найдено!");
        }
        return spellEvent;
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        List<SpellEvent> spellEvents = spellsByType.get(eventType);
        if (spellEvents != null) {
            System.out.print(spellsByType.get(eventType));
        } else {
            System.out.print("Заклинание не найдено!" + eventType);
        }
        return spellEvents;
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            List<SpellEvent> events = spellsByType.get(spellEvent.getEventType());
            if (events != null) {
                events.remove(spellEvent);
                if (events.isEmpty()) {
                    spellsByType.remove(spellEvent.getEventType());
                }
            }
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entryId : spellById.entrySet()) {
            System.out.println(entryId);
        }
        for (Map.Entry<String, List<SpellEvent>> entryType : spellsByType.entrySet()) {
            System.out.println(entryType);
        }
    }
}
