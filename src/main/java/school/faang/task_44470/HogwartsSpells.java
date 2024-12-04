package school.faang.task_44470;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            List<SpellEvent> spellEvents = spellsByType.get(spellEvent.getEventType());
            if (spellEvents != null) {
                spellEvents.remove(spellEvent);
                if (spellEvents.isEmpty()) {
                    spellsByType.remove(spellEvent.getEventType());
                }
            }
        }
    }

    public void printAllSpellEvents() {
        System.out.println("Все spellEvents: ");
        spellById.forEach((key, spellEvent) -> System.out.println(spellEvent));
    }
}
