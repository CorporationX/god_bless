package school.faang.bjs2_85845;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellByType = new HashMap<>();

    public HogwartsSpells() {

    }

    public void addSpellEvent(String eventType, String action) {
        SpellEvent spellEvent = new SpellEvent(eventType, action);
        int id = SpellEvent.getId();
        spellById.put(id, spellEvent);
        spellByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEventToDelete = spellById.remove(id);
        if (spellEventToDelete != null) {
            String spellTypeToDelete = spellEventToDelete.getEventType();
            List<SpellEvent> spellEventsToCheck = spellByType.get(spellTypeToDelete);
            spellEventsToCheck.remove(spellEventToDelete);
            if (spellEventsToCheck.isEmpty()) {
                spellByType.remove(spellTypeToDelete);
            }
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.printf("ID: %d, Spell: %s, Info: %s\n",
                    entry.getKey(),
                    entry.getValue().getEventType(),
                    entry.getValue().getAction());
        }
    }
}
