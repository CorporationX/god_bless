package school.faang.catch_events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private static final String INCORRECT_ID = "There isn't any spells with such ID";

    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        if (spellById.get(id) == null) {
            System.out.println(INCORRECT_ID);
        }
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            System.out.println("Spell with id " + id + " was deleted");
            List<SpellEvent> events = spellsByType.get(spellEvent.getEventType());
            if (events != null) {
                events.remove(spellEvent);
                if (events.isEmpty()) {
                    spellsByType.remove(spellEvent.getEventType());
                }
            }
        } else {
            System.out.println(INCORRECT_ID);
        }
    }

    public void printAllSpellEvents() {
        spellById.forEach((id, spellEvent) -> System.out.println(id + " " + spellEvent));
    }
}
