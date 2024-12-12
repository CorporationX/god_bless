package school.faang.sprint1.bjs244652;

import lombok.EqualsAndHashCode;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

@EqualsAndHashCode
public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);
        System.out.println("Событие " + spellEvent + " было добавлено в Map.");
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsType(String eventType) {
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            spellsByType.computeIfPresent(spellEvent.getEventType(), (eventType, events) -> {
                events.remove(spellEvent);
                return events.isEmpty() ? null : events;
            });
        }
    }

    public void printAllSpellEvents() {
        System.out.println("\nВсе события заклинаний, которые есть в Map:");
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
