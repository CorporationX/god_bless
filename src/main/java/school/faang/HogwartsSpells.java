package school.faang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private int currentId = 1;

    public void addSpellEvent(String eventType, String action) {
        int id = currentId++;
        SpellEvent spellEvent = new SpellEvent(id, eventType, action);

        spellById.put(id, spellEvent);
        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        if (spellsByType.containsKey(eventType)) {
            return spellsByType.get(eventType);
        }
        return Collections.emptyList();
    }

    public void deleteSpellEvent(int id) {
        SpellEvent event = spellById.remove(id);
        if (event != null) {
            List<SpellEvent> events = spellsByType.get(event.getEventType());
            if (events != null) {
                events.remove(event);
                if (events.isEmpty()) {
                    spellsByType.remove(event.getEventType());
                }
            }
        }
    }


    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

}
