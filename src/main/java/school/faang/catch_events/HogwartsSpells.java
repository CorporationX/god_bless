package school.faang.catch_events;

import java.util.*;


public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private final Random random = new Random();

    public void addSpellEvent(String eventType, String actionDescription) {
        int id = random.nextInt(100) + 1;

        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);

        spellById.put(spellEvent.getId(), spellEvent);

        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent removeEvent = spellById.remove(id);

        if (removeEvent != null) {
            spellsByType.remove(removeEvent.getEventType());
        }

    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getKey() + ": "
                    + entry.getValue().getEventType()
                    + " - "
                    + entry.getValue().getAction());
        }
    }
}