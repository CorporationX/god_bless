package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HogwartsSpells {
    private final HashMap<Integer, SpellEvent> spellById = new HashMap<>();
    private final HashMap<String, List<SpellEvent>> spellByType = new HashMap<>();

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);

        spellById.put(id, spellEvent);
        List<SpellEvent> spellList = spellByType.get(eventType);
        if (spellList == null) {
            spellList = new ArrayList<>();
        }
        spellList.add(spellEvent);
        spellByType.put(eventType, spellList);
    }


    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        String spellToDelete = spellById.get(id).getEventType();
        List<SpellEvent> eventsToRemoveFrom = spellByType.get(spellToDelete);
        spellById.remove(id);
        for (SpellEvent spellEvent : eventsToRemoveFrom) {
            if (spellEvent.getId() == id) {
                eventsToRemoveFrom.remove(spellEvent);
                if (eventsToRemoveFrom.isEmpty()) {
                    spellByType.remove(spellEvent.getEventType());
                }
                break;
            }

        }
    }

    public void printAllSpellEvents() {
        for (SpellEvent spellEvent : spellById.values()) {
            System.out.println(spellEvent.getId() + " "
                    + spellEvent.getEventType() + " "
                    + spellEvent.getAction());
        }
    }
}

