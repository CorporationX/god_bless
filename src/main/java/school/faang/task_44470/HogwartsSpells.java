package school.faang.task_44470;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private int nextId = 0;

    public int addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(nextId, eventType, actionDescription);
        spellById.put(nextId, spellEvent);
        spellsByType.computeIfAbsent(eventType, key->new ArrayList<>()).add(spellEvent);
        return nextId++;
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public boolean deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            List<SpellEvent> spellEvents = spellsByType.get(spellEvent.getEventType());
            if (spellEvents != null) {
                spellEvents.remove(spellEvent);
                if (spellEvents.isEmpty()) {
                    spellsByType.remove(spellEvent.getEventType());
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public void printAllSpellEvents() {
        System.out.println("Все spellEvents: ");
        spellById.forEach((key, spellEvent) -> System.out.println(spellEvent));
    }
}
