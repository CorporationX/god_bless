package school.faang.eventhandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Related to JIRA ticket: BJS2-68668
 */
public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        if (eventType == null || actionDescription == null || eventType.isEmpty() || actionDescription.isEmpty()) {
            throw new IllegalArgumentException("The wrong parameters!");
        }
        SpellEvent spellEvent = new SpellEvent(eventType, actionDescription);
        List<SpellEvent> spellEvents = spellByType.computeIfAbsent(eventType, k -> new ArrayList<>());
        spellEvents.add(spellEvent);
        spellById.put(spellEvent.getId(), spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        if (!spellById.containsKey(id)) {
            throw new IllegalArgumentException("The ID is not valid!");
        }
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        if (!spellByType.containsKey(eventType)) {
            throw new IllegalArgumentException("The event type is not valid!");
        }
        return spellByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        if (!spellById.containsKey(id)) {
            throw new IllegalArgumentException("The ID is not valid!");
        }
        SpellEvent spellEvent = spellById.get(id);
        String eventType = spellEvent.getEventType();

        List<SpellEvent> spellEvents = spellByType.get(eventType);
        if (spellEvents != null) {
            spellEvents.removeIf(s -> s.getId() == spellEvent.getId());
            if (spellEvents.isEmpty()) {
                spellByType.remove(eventType);
            }
        }
        spellById.remove(id);
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.printf("Spell id: %d, spellEvent: %s\n", entry.getKey(), entry.getValue());
        }
    }
}
