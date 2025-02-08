package school.faang.catchevents;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(eventType, actionDescription);
        spellById.put(spellEvent.getId(), spellEvent);
        if (!spellsByType.containsKey(eventType)) {
            spellsByType.put(eventType, new ArrayList<>());
        }
        spellsByType.get(eventType).add(spellEvent);
        if (spellsByType.get(eventType).contains(spellEvent)) {
            System.out.println("spell event was added successfully");
        }
    }

    public SpellEvent getSpellEventById(int id) {
        if (spellById.containsKey(id)) {
            return spellById.get(id);
        } else {
            System.out.println("There is no spell event with this id");
            return null;
        }
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        if (spellsByType.containsKey(eventType)) {
            return spellsByType.get(eventType);
        } else {
            System.out.println("There is no spell events with this type");
            return null;
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
