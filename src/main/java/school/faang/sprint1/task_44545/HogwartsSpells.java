package school.faang.sprint1.task_44545;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {

    private final HashMap<Long, SpellEvent> spellById = new HashMap<>();
    private final HashMap<String, ArrayList<SpellEvent>> spellsByType = new HashMap<>();
    private long nextId = 0;

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(nextId, actionDescription, eventType);
        spellById.put(nextId, spellEvent);
        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(spellEvent);
        nextId++;
    }

    public SpellEvent getSpellEventById(long id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(long id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            spellsByType.get(spellEvent.getEvenType()).remove(spellEvent);
        }
    }

    public void printAllSpellEvents() {
        System.out.println("----- SPELL EVENTS -----");
        for (Map.Entry<Long, SpellEvent> spellEventEntry : spellById.entrySet()) {
            System.out.printf(
                    "spellEvent: %s \n",
                    spellEventEntry.getValue()
            );
        }
    }
}
