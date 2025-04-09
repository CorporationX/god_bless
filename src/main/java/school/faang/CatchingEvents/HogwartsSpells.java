package school.faang.CatchingEvents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        int id = spellById.size() + 1;
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        if (spellsByType.containsKey(eventType)) {
            spellsByType.get(eventType).add(spellEvent);
        } else {
            spellsByType.put(eventType, new ArrayList<>(Stream.of(spellEvent).toList()));
        }
    }

    public SpellEvent getSpellEventById(int id) {
        if (spellById.containsKey(id)) {
            return spellById.get(id);
        }
        return null;
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, null);
    }

    public boolean deleteSpellEvent(int id) {
        if (!spellById.containsKey(id)) {
            return false;
        } else {
            String eventTypeById = spellById.get(id).getEventType();
            if (spellsByType.get(eventTypeById).size() == 1) {
                spellsByType.remove(eventTypeById);
            } else {
                spellsByType.get(eventTypeById).remove(spellById.get(id));
            }
            spellById.remove(id);
            return true;
        }
    }

    public void printAllSpellEvents() {
        for (SpellEvent spellEvent : spellById.values()) {
            System.out.println(spellEvent);
        }
    }
}
