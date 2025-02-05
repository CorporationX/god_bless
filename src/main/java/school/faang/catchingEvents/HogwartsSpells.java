package school.faang.catchingEvents;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class HogwartsSpells {
    private static int count = 1;
    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellByType = new HashMap<>();

    public void addSpellEvent(String name,  String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(count, name, eventType, actionDescription);
        spellById.put(count, spellEvent);
        count++;
        if (spellByType.containsKey(eventType)) {
            spellByType.get(eventType).add(spellEvent);
        } else {
            List<SpellEvent> spellEvents = new ArrayList<>();
            spellEvents.add(spellEvent);
            spellByType.put(eventType, spellEvents);
        }
    }

    public SpellEvent getSpellEventById(int id) {
        if (spellById.containsKey(id)) {
            return spellById.get(id);
        } else {
            throw new IllegalArgumentException("There is no spell with this number.");
        }
    }

    public List<SpellEvent> getSpellsByType(String eventType) {
        if (spellByType.containsKey(eventType)) {
            return spellByType.get(eventType);
        } else {
            throw new IllegalArgumentException("There is no spells with this type.");
        }
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            spellByType.remove(spellEvent.getEventType());
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
