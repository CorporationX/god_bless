package school.faang.task_44416;

import java.util.*;

public class HogwartsSpells {
    Map<Integer, SpellEvent> spellsById = new HashMap<Integer, SpellEvent>();
    Map<String, List<SpellEvent>> spellsByType = new HashMap<String, List<SpellEvent>>();

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellsById.computeIfAbsent(id, k -> spellEvent);
        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<SpellEvent>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellsById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        spellsById.remove(id);
        spellsByType.values().forEach(spellEvents -> {
            spellEvents.removeIf(spellEvent -> spellEvent.getId() == id);
        });
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> spellEvent : spellsById.entrySet()) {
            System.out.println(
                    "Id: " + spellEvent.getKey()
                    + " Type: " + spellEvent.getValue().getEventType()
                    + " Action: " + spellEvent.getValue().getAction()
            );
        }
    }
}
