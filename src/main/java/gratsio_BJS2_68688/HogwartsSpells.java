package gratsio_BJS2_68688;

import java.util.*;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private int spellCurrentId = 1;

    public void addSpellEvent(String eventType, String actionDescription) {
        int id = spellCurrentId++;
        SpellEvent spell = new SpellEvent(id, eventType, actionDescription);

        spellById.put(id, spell);
        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(spell);
    }

    public SpellEvent getSpellEventById(int id) {
        if(spellById.containsKey(id)) {
            return spellById.get(id);
        }
        return null;
    }

    public List<SpellEvent> getSpellEventByType(String eventType) {
        if(spellsByType.containsKey(eventType)) {
            return new ArrayList<>(spellsByType.get(eventType));
        }
        return Collections.emptyList();
    }

    public void deleteSpellEventsByType(int id) {
        if(spellsByType.get(spellById.get(id).getEventType()).isEmpty()) {
            spellsByType.remove(spellById.get(id).getEventType());
        } else {
            spellsByType.get(spellById.get(id).getEventType()).remove(spellById.get(id));
        }
        spellById.remove(id);
    }

    public void printAllSpellEvents() {
        for(Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
