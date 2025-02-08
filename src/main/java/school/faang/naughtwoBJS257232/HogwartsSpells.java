package school.faang.naughtwoBJS257232;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private int lastId = 1;

    public void addSpellEvent(String eventType, String action) {
        int key = lastId;
        SpellEvent spellEvent = new SpellEvent(key, eventType, action);

        spellById.put(key, spellEvent);

        if (!spellsByType.containsKey(eventType)) {
            spellsByType.put(eventType, new ArrayList<>());
            spellsByType.get(eventType).add(spellEvent);
        } else {
            spellsByType.get(eventType).add(spellEvent);
        }
        lastId++;
    }

    public Optional<SpellEvent> getSpellEventById(int id) {
        if (!spellById.containsKey(id)) {
            System.out.println("Event not found for this ID");
            return Optional.empty();
        } else {
            System.out.println("Event found for this ID");
            return Optional.ofNullable(spellById.get(id));
        }
    }

    public Optional<List<SpellEvent>> getSpellEventsByType(String eventType) {
        if (!spellsByType.containsKey(eventType)) {
            System.out.println("List of events not found for this type");
            return Optional.empty();
        } else {
            System.out.println("List of events found for this type");
            return Optional.ofNullable(spellsByType.get(eventType));
        }
    }

    public void deleteSpellEvent(int id) {
        if (!spellById.containsKey(id)) {
            System.out.println("Event not found for this ID");
        } else {
            String eventType = spellById.get(id).getEventType();
            spellById.remove(id);
            spellsByType.get(eventType).removeIf(spellEvent -> spellEvent.getId() == id);
            System.out.println("Event for this ID found and remove");
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public void printAllSpellEventsByType() {
        for (Map.Entry<String, List<SpellEvent>> entry : spellsByType.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
