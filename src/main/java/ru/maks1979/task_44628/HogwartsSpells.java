package ru.maks1979.task_44628;


import java.util.*;


public class HogwartsSpells {
    public Map<Integer, SpellEvent> spellById;
    public Map<String, List<SpellEvent>> spellByType;

    public HogwartsSpells() {
        spellById = new HashMap<>();
        spellByType = new HashMap<>();
    }

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent newSpellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, newSpellEvent);
        if (!spellByType.containsValue(eventType)) {
            spellByType.put(eventType, new ArrayList<SpellEvent>());
        }
        spellByType.get(eventType).add(newSpellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        spellById.remove(id);
        spellByType.remove(spellById.get(id));
    }

    public void printAllSpellEvents(SpellEvent spellEvent) {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}

