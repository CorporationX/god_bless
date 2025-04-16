package school.faang.catch_events;

import java.util.*;


public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellByID = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private final Random random = new Random();

    public void addSpellEvent(String eventType, String actionDescription) {
        int id = random.nextInt(100) + 1;

        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);

        spellByID.put(spellEvent.getId(), spellEvent);

        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellByID.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent removeEvent = spellByID.remove(id);

        if (removeEvent != null) {
            spellsByType.remove(removeEvent.getEventType());
        }

    }

    public void printAllSpellEvents() {
        for(Map.Entry<Integer, SpellEvent> entry : spellByID.entrySet()){
            System.out.println(entry.getKey() + ": "
                    + entry.getValue().getEventType()
                    + " - "
                    + entry.getValue().getAction());
        }
    }
}