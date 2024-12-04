package school.faang.task44424;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellsById;
    private Map<String, List<SpellEvent>> spellsByType;

    public HogwartsSpells() {
        this.spellsById = new HashMap<>();
        this.spellsByType = new HashMap<>();
    }

    private void validationEventAction(String eventType, String actionDescription) {
        StringBuilder exceptionMessage = new StringBuilder();
        if (eventType == null) {
            exceptionMessage.append("Event type is null!\t");
        }
        if (actionDescription == null) {
            exceptionMessage.append("Action description is null!\t");
        }
        if (!exceptionMessage.toString().isEmpty()) {
            throw new IllegalArgumentException(exceptionMessage.toString());
        }
    }

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        try {
            validationEventAction(eventType, actionDescription);
            SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);

            spellsByType.putIfAbsent(spellEvent.getEventType(), new ArrayList<>());

            if (spellsById.putIfAbsent(spellEvent.getId(), spellEvent) != null) {
                throw new IllegalArgumentException("Spell event already exists!");
            }

            spellsByType.get(eventType).add(spellEvent);
            System.out.println("Added spell " + spellEvent + " to " + id);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public SpellEvent getSpellsById(int id) {
        try {
            if (!spellsById.containsKey(id)) {
                throw new IllegalArgumentException("Spell by id " + id + " not found\n");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Spell by id " + spellsById.get(id) + "\n");
        return spellsById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        try {
            if (!spellsByType.containsKey(eventType)) {
                throw new IllegalArgumentException("Spell by type " + eventType + "not found\n");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        try {
            SpellEvent removedSpellEvent = getSpellsById(id);
            String removedElement = removedSpellEvent.getEventType();

            if (!spellsByType.get(removedElement).contains(removedSpellEvent)) {
                throw new IllegalArgumentException("Spell by type "
                        + removedSpellEvent.getEventType() + " not found\n");
            }
            spellsByType.get(removedElement).remove(removedSpellEvent);
            System.out.println("Removed spell " + spellsById.remove(id) + "\n");

        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printAllSpellEvents() {
        try {
            if (spellsById.isEmpty()) {
                throw new IllegalArgumentException("No spell events found\n");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        for (var event : spellsById.values()) {
            System.out.println(event);
        }
    }
}
