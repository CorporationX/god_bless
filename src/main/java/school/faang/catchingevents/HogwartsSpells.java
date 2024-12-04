package school.faang.catchingevents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private HashMap<Integer, SpellEvent> spellById = new HashMap<>();
    private HashMap<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);

        spellById.put(id, spellEvent);

        if (!spellsByType.containsKey(eventType)) {
            spellsByType.put(eventType, new ArrayList<>());
        }
        List<SpellEvent> spellEvents = spellsByType.get(eventType);
        spellEvents.add(spellEvent);
        spellsByType.put(eventType, spellEvents);
        System.out.println("Added a new spell event");
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String type) {
        return spellsByType.get(type);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent target = spellById.get(id);
        List<SpellEvent> spellEvents = spellsByType.get(target.getEventType());
        spellEvents.removeIf(spellEvent -> spellEvent.getId() == id);
        spellById.remove(id);
        System.out.println("element " + id + " was removed");
    }

    public void printAllSpellEvents() {
        if (spellById.size() == 0) {
            System.out.println("Spell events not found");
            return;
        }
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            SpellEvent spellEvent = entry.getValue();
            System.out.println(
                    spellEvent.getId() + "|"
                            + spellEvent.getEventType() + "|"
                            + spellEvent.getAction()
            );
        }
    }
}
