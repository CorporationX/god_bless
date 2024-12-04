package school.faang.task_44481;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spellEventToAdd = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEventToAdd);

        spellsByType.computeIfAbsent(eventType, key -> new ArrayList<>()).add(spellEventToAdd);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEventToDelete = getSpellEventById(id);
        if (spellEventToDelete == null) {
            throw new IllegalArgumentException("No spell event with id " + id + " found");
        }
        spellById.remove(id);

        String spellEventToDeleteEventType = spellEventToDelete.getEventType();
        spellsByType.get(spellEventToDeleteEventType).remove(spellEventToDelete);
    }

    public void printAllSpellEvents() {
        System.out.println("Printing all spell events...");
        if (spellById.isEmpty()) {
            System.out.println("There are no spell events in Hogwarts");
        }
        for (SpellEvent spellEvent : spellById.values()) {
            System.out.println(spellEvent);
        }
        System.out.println("End of printing all spell events.");
    }

}
