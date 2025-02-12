package school.faang.BJS2_57150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private int currentSpellId = 1;

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(currentSpellId, eventType, actionDescription);
        spellById.put(currentSpellId, spellEvent);
        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);
        currentSpellId++;
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public void deleteSpellEvent(int id) {
        if (id < currentSpellId) {
            SpellEvent spellEvent = spellById.remove(id);
            spellsByType.get(spellEvent.getEventType()).remove(spellEvent);
            if (spellsByType.get(spellEvent.getEventType()).isEmpty()) {
                spellsByType.remove(spellEvent.getEventType());
            }
        }
    }

    public void printAllSpellEvents() {
        System.out.println("Список заклинаний:");
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            SpellEvent spellEvent = entry.getValue();
            System.out.printf("%s: %s - %s \n", spellEvent.getId(), spellEvent.getEventType(), spellEvent.getAction());
        }
    }
}
