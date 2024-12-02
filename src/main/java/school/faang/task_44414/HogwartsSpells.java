package school.faang.task_44414;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById;
    private Map<String, List<SpellEvent>> spellsByType;

    public HogwartsSpells() {
        this.spellById = new HashMap<>();
        this.spellsByType = new HashMap<>();
    }

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        List<SpellEvent> spellEvents = getSpellEventsByType(eventType);
        if (spellEvents == null) {
            spellEvents = new ArrayList<>();
        }
        spellEvents.add(spellEvent);
        spellsByType.put(eventType, spellEvents);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent event = spellById.remove(id);
        if (event != null) {
            List<SpellEvent> spellEvents = getSpellEventsByType(event.getEventType());
            if (spellEvents != null) {
                spellEvents.remove(event);
            }
        }
    }

    public void printAllSpellEvents() {
        System.out.println("SPELLS BY ID:");
        for (Map.Entry entry : spellById.entrySet()) {
            System.out.println(entry);
        }
        System.out.println("SPELLS BY TYPE:");
        for (Map.Entry entry : spellsByType.entrySet()) {
            System.out.println(entry);
        }
        System.out.println("===============================");
    }
}
