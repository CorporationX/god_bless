package school.faang.task44690.service;

import school.faang.task44690.model.SpellEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById;
    private final Map<String, List<SpellEvent>> spellByType;

    public HogwartsSpells() {
        spellById = new HashMap<>();
        spellByType = new HashMap<>();
    }

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent event = new SpellEvent(id, eventType, actionDescription);

        spellById.put(id, event);
        spellByType.putIfAbsent(eventType, new ArrayList<>());
        spellByType.get(eventType).add(event);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent event = spellById.get(id);
        spellByType.remove(event.getEventType());
        spellById.remove(id);
    }

    public void printAllSpellEvents() {
        System.out.println("All spell events:");
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println("Spell: " + entry.getValue());
        }
    }
}
