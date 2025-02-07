package school.faang.catchevents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    Map<Integer, SpellEvent> spellById = new HashMap<>();
    Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(eventType, actionDescription);
        spellById.put(spellEvent.getId(), spellEvent);
        if (!spellsByType.containsKey(eventType)) {
            spellsByType.put(eventType, new ArrayList<>());
        }
        spellsByType.get(eventType).add(spellEvent);
    }

    public void getSpellEventById(int id) {
        if (spellById.containsKey(id)) {
            System.out.println(spellById.get(id));
        } else {
            System.out.println("There is no spell event with this id");
        }
    }

    public void getSpellEventsByType(String eventType) {
        if (spellsByType.containsKey(eventType)) {
            for (SpellEvent spellEvent : spellsByType.get(eventType)) {
                System.out.println(spellEvent);
            }
        }
        if (!spellsByType.containsKey(eventType) || spellsByType.get(eventType).isEmpty()) {
            System.out.println("There is no spell event with this type");
        }
    }

    public void deleteSpellEvent(int id) {
        if (spellById.containsKey(id)) {
            spellsByType.get(spellById.get(id).getEventType()).removeIf(spellEvent -> spellEvent.getId() == id);
            spellById.remove(id);
            System.out.println("Spell event is deleted from spellById and spellByType maps");
        } else {
            System.out.println("There is no spell event with this id");
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> spellEventEntry : spellById.entrySet()) {
            System.out.println("spell: " + spellEventEntry.getValue());
        }
    }
}
