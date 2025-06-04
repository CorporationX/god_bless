package school.faang.catching_events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    Map<Integer, SpellEvent> spellById = new HashMap<>();
    Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(eventType, actionDescription);
        spellById.put(spellEvent.getID(), spellEvent);
        if (spellsByType.isEmpty() || !spellsByType.containsKey(eventType)) {
            List<SpellEvent> spellEventList = new ArrayList<>();
            spellEventList.add(spellEvent);
            spellsByType.put(eventType, spellEventList);
        } else {
            spellsByType.get(eventType).add(spellEvent);
        }
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        spellsByType.get(spellById.get(id).getEventType()).remove(spellById.get(id));
        spellById.remove(id);
    }

    public void printAllSpellEvents() {
        for (Map.Entry spell : spellById.entrySet()) {
            System.out.println(spell);
        }
        System.out.println("\n********************************************\n");
    }
}
