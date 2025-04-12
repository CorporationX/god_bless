package school.faang.cathingspells;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class HogwartsSpells {
    private HashMap<Integer, SpellEvent> spellById;
    private HashMap<String, List<SpellEvent>> spellsByType;

    public SpellEvent addSpellEvent(String eventType, String actionDescription) {
        Integer uniqueId = Integer.parseInt(UUID.randomUUID().toString());
        SpellEvent spellEvent = new SpellEvent(uniqueId, eventType, actionDescription);
        spellById.put(uniqueId, spellEvent);
        List<SpellEvent> thisTypeSpellEvents = new ArrayList<>();
        if (spellsByType.containsKey(eventType)) {
            thisTypeSpellEvents.addAll(spellsByType.get(eventType));
        }
        thisTypeSpellEvents.add(spellEvent);
        spellsByType.put(eventType, thisTypeSpellEvents);
        return spellEvent;
    }

    public SpellEvent getSpellEventById(int id) {
        SpellEvent spellEvent = spellById.get(id);
        return spellEvent;
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        List<SpellEvent> thisTypeSpellEvents = spellsByType.get(eventType);
        return thisTypeSpellEvents;
    }

    public SpellEvent deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.get(id);
        spellById.remove(id);
        spellsByType.get(spellEvent.getEventType()).remove(spellEvent);
        return spellEvent;
    }

    public void printAllSpellEvents() {
        spellById.forEach((id, spellEvent) -> {
            System.out.println("ID: " + id + ", Event Type: " + spellEvent.getEventType() + ", Action: " + spellEvent.getAction());
        });
    }
}
