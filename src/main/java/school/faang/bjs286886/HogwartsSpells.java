package school.faang.bjs286886;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private HashMap<Integer, SpellEvent> spellById;
    private HashMap<String, List<SpellEvent>> spellsByType;
    static int id = 1;

    public HogwartsSpells() {
        this.spellById = new HashMap<>();
        this.spellsByType = new HashMap<>();
    }

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);

        spellById.put(id, spellEvent);

        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);

        id++;
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            List<SpellEvent> spellEvents = spellsByType.get(spellEvent.getEventType());
            if (spellEvents != null) {
                spellEvents.remove(spellEvent);
            }
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> spellEvent : spellById.entrySet()) {
            System.out.println(spellEvent.getValue());
        }
    }
}
