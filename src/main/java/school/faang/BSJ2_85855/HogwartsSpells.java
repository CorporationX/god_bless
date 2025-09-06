package school.faang.BSJ2_85855;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class HogwartsSpells {
    Map<Integer, SpellEvent> spellById = new HashMap<>();
    Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        List<SpellEvent> spellEvents = new ArrayList<>();
        int uniqueIdenticator = Objects.hash(eventType, actionDescription);
        SpellEvent spellEvent = new SpellEvent(uniqueIdenticator, eventType, actionDescription);
        spellById.put(uniqueIdenticator, spellEvent);
        if (spellsByType.get(eventType) != null) {
            spellEvents = spellsByType.get(eventType);
        }
        spellEvents.add(spellEvent);
        spellsByType.put(eventType, spellEvents);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public boolean deleteSpellEvent(int id) {
        SpellEvent deletedSpellEvent = spellById.remove(id);
        if (deletedSpellEvent != null) {
            spellsByType.remove(deletedSpellEvent.getEventType());
            return true;
        } else {
            return false;
        }
    }

    public void printAllSpellEvents() {
        for (SpellEvent spellEvent : spellById.values()) {
            System.out.println(spellEvent.toString());
        }
    }
}
