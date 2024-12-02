package school.faang.task_BJS2_43512;

import java.util.*;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private List<SpellEvent> spellEventList = new ArrayList<>();

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        if (id < 0 && eventType == null && eventType.isBlank() && actionDescription == null
                && actionDescription.isBlank()) {
            throw new IllegalArgumentException();
        }
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        spellEventList.add(spellEvent);

        spellsByType.put(eventType, spellEventList);
    }

    public SpellEvent getSpellEventById(int id) {
        if (id < 0) {
            throw new IllegalArgumentException();
        }
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        if (eventType.isBlank() && eventType == null) {
            throw new IllegalArgumentException();
        }
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        if (id < 0) {
            throw new IllegalArgumentException();
        }
        spellById.remove(id);
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println("Spell Event: id " + entry.getValue().getId() + " type "
                    + entry.getValue().getEventType()
                    + " action " + entry.getValue().getAction());
        }
    }
}
