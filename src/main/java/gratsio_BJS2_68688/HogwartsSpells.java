package gratsio_BJS2_68688;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void getSpellEventById(int id) {
        if(spellById.containsKey(id)) {
            System.out.println(spellById.get(id));
        } else {
            System.out.println("There is no such spell event in our spell storage " +
                    "and management system!");
        }
    }
    public void getSpellEventByType(String eventType) {
        if(spellsByType.containsKey(eventType)) {
            System.out.println(eventType + ":");
            for(Map.Entry<String, List<SpellEvent>> entry : spellsByType.entrySet()) {
                if(entry.getKey().equals(eventType)) {
                    System.out.println(entry.getValue());
                }
            }
        }
    }
    public void deleteSpellEventsByType(int id) {
        if(spellsByType.containsKey(spellById.get(id).getEventType())) {
            System.out.println("The spell with id " + id + " has been removed" +
                    " from the spell storage and management system!");
            if(!spellsByType.get(spellById.get(id).getEventType()).isEmpty()) {
                spellsByType.get(spellById.get(id).getEventType()).remove(spellById.get(id));
                spellById.remove(id);
            } else {
                spellsByType.remove(spellById.get(id).getEventType());
                spellById.remove(id);
            }
        } else {
            System.out.println("The event of such a spell cannot be deleted " +
                    "as it is missing from our spell storage and management system!");
        }
    }
    public void printAllSpellEvents() {
        for(Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
