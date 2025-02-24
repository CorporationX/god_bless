package school.faang.capturingevents;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {

    private Map<Integer, SpellEvent> spellById;
    private Map<String, List<SpellEvent>> spellsByType;

    public HogwartsSpells(Map<Integer, SpellEvent> spellById,
                          Map<String, List<SpellEvent>> spellsByType) {
        this.spellById = spellById;
        this.spellsByType = spellsByType;
    }

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            spellsByType.remove(spellEvent.getEventType());
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    @Override
    public String toString() {
        return String.format("HogwartsSpells{spellById=%s, spellsByType=%s}", spellById, spellsByType);
    }

}
