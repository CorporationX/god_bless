package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HogwartsSpells {
    public HashMap<Integer, SpellEvent> spellById = new HashMap<>();
    public HashMap<String, List<SpellEvent>> spellByType = new HashMap<>();

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);

        spellById.put(id, spellEvent);
        List<SpellEvent> spellList = spellByType.get(eventType);
        if (spellList == null) {
            spellList = new ArrayList<>();
            spellByType.put(eventType, spellList);
        }
        spellList.add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        spellById.remove(id);
        for (List<SpellEvent> spellList : spellByType.values()) {
            for (SpellEvent spellEvent : spellList) {
                if (spellEvent.id == id) {
                    spellList.remove(spellEvent);
                    break;
                }
            }
        }
    }

    public void printAllSpellEvents() {
        for (SpellEvent spellEvent : spellById.values()) {
            System.out.println(spellEvent.id + " " + spellEvent.eventType + " " + spellEvent.action);
        }
    }
}

