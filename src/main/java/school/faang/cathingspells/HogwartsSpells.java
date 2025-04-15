package school.faang.cathingspells;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
public class HogwartsSpells {
    private HashMap<Integer, SpellEvent> spellById;
    private HashMap<String, List<SpellEvent>> spellsByType;
    private Integer uniqueId = 1;

    public HogwartsSpells() {
        this.spellById = new HashMap<>();
        this.spellsByType = new HashMap<>();
    }

    public SpellEvent addSpellEvent(String eventType, String actionDescription) {
        Integer uniqueId = getNewUniqueId();
        SpellEvent spellEvent = new SpellEvent(uniqueId, eventType, actionDescription);
        spellById.put(uniqueId, spellEvent);
        List<SpellEvent> thisTypeSpellEvents = spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>());
        thisTypeSpellEvents.add(spellEvent);
        spellsByType.put(eventType, thisTypeSpellEvents);
        return spellEvent;
    }

    private Integer getNewUniqueId() {
        return uniqueId++;
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public String deleteSpellEvent(int id) {
        if (spellById.containsKey(id)) {
            SpellEvent spellEvent = spellById.get(id);
            spellById.remove(id);
            spellsByType.get(spellEvent.getEventType()).remove(spellEvent);
            return String.format("Spell with id %d, type %s, %s is no more in list",
                    spellEvent.getId(), spellEvent.getEventType(), spellEvent.getAction());
        }
        return String.format("There was no spell with id %d", id);
    }

    public void printAllSpellEvents() {
        spellById.forEach((id, spellEvent) -> {
            System.out.println("ID: " + id + ", Event Type: " + spellEvent.getEventType() +
                    ", Action: " + spellEvent.getAction());
        });
    }
}
