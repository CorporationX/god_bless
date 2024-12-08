package school.faang.task_44416;

import java.util.*;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellsById = new HashMap<Integer, SpellEvent>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<String, List<SpellEvent>>();

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellsById.computeIfAbsent(id, k -> spellEvent);
        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<SpellEvent>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        if (!spellsById.containsKey(id)) {
            throw new NoSuchElementException("SpellEvent с Id: " + id + " не был найден!");
        }
        return spellsById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        if (!spellsByType.containsKey(eventType)) {
            throw new NoSuchElementException("List<SpellEvent> с eventType: " + eventType + " не был найден!");
        }
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        spellsById.remove(id);
        spellsByType.values().forEach(spellEvents -> {
            spellEvents.removeIf(spellEvent -> spellEvent.id() == id);
        });
    }

    public void printAllSpellEvents() {

        spellsById.forEach((id, spellEvent) ->
                System.out.println(
                        "Id: " + spellEvent.id()
                                + " Type: " + spellEvent.eventType()
                                + " Action: " + spellEvent.action()
                )
        );


    }
}
