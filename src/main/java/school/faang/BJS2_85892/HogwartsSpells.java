package school.faang.BJS2_85892;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {

    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        if (eventType == null || eventType.isBlank() || actionDescription == null || actionDescription.isBlank()) {
            System.out.println("Either eventType or actionDescription is/are NULL, please provide valid values");
            return;
        }
        SpellEvent newSpellEvent = new SpellEvent(eventType, actionDescription);
        spellById.put(newSpellEvent.getId(), newSpellEvent);
        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(newSpellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEventForRemoval = spellById.get(id);
        spellById.remove(id);
        spellsByType
                .get(spellEventForRemoval
                .getEventType())
                .remove(spellEventForRemoval);
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.printf("%s => %s => %s%n",
                    entry.getKey(),
                    entry.getValue().getEventType(),
                    entry.getValue().getAction());
        }
    }
}
