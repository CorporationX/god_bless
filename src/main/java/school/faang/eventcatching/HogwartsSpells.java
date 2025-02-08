package school.faang.eventcatching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class HogwartsSpells {

    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public boolean addSpellEvent(String eventType, String actionDescription) {
        if (eventType.isBlank() || actionDescription.isBlank()) {
            throw new IllegalArgumentException("Event type and action description cannot be blank");
        }

        int randomId = getRandomId();
        SpellEvent spellEvent = new SpellEvent(randomId, eventType, actionDescription);

        if (!spellById.containsValue(spellEvent)) {
            spellById.put(randomId, spellEvent);
            spellsByType.putIfAbsent(eventType, new ArrayList<>());
            spellsByType.get(eventType).add(spellEvent);
            return true;
        }

        return false;
    }

    public SpellEvent getSpellEventById(int id) {
        if (id < 1 || !spellById.containsKey(id)) {
            throw new IllegalArgumentException("No spell event with id " + id);
        }
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        if (!spellsByType.containsKey(eventType)) {
            throw new IllegalArgumentException("No spell event with type " + eventType);
        }
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        if (id < 1 || !spellById.containsKey(id)) {
            throw new IllegalArgumentException("No spell event with id " + id);
        }
        spellsByType.get(spellById.get(id).getEventType()).remove(spellById.get(id));
        spellById.remove(id);
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(String.format("Id %s is type %s , is action %s",
                    entry.getKey(), entry.getValue().getEventType(), entry.getValue().getAction()));
        }
    }

    private int getRandomId() {
        Random rand = new Random();
        int randomId = 1;
        while (spellById.containsKey(randomId)) {
            randomId = rand.nextInt(1, 100);
        }
        return randomId;

    }

}
