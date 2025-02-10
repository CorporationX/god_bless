package school.faang.eventcatching;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private static int idCounter = 1;
    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public boolean addSpellEvent(String eventType, String actionDescription) {
        if (eventType.isBlank() || actionDescription.isBlank()) {
            throw new IllegalArgumentException("Event type and action description cannot be blank");
        }

        int randomId = idCounter++;
        SpellEvent spellEvent = new SpellEvent(randomId, eventType, actionDescription);
        if (spellById.containsValue(spellEvent)) {
            return false;
        }
        spellById.put(randomId, spellEvent);
        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);
        return true;

    }

    public SpellEvent getSpellEventById(int id) {
        if (id < 1 || !spellById.containsKey(id)) {
            throw new IllegalArgumentException("No spell event with id " + id);
        }
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        if (!spellsByType.containsKey(eventType)) {
            System.out.println(MessageFormat.format("No spell event with type {0} ", eventType));
        }
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public void deleteSpellEvent(int id) {
        if (id < 1 || !spellById.containsKey(id)) {
            throw new IllegalArgumentException("No spell event with id " + id);
        }
        SpellEvent removeSpell = spellById.get(id);
        String removeEventType = removeSpell.getEventType();
        spellsByType.get(removeEventType).remove(spellById.get(id));
        spellById.remove(id);
        List<SpellEvent> spellOfType = spellsByType.get(removeEventType);
        if (spellOfType.isEmpty()) {
            spellsByType.remove(removeEventType);
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(String.format("Id %s is type %s , is action %s",
                    entry.getKey(), entry.getValue().getEventType(), entry.getValue().getAction()));
        }
    }

}
