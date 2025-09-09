package school.faang.magieDigga;

import java.util.*;

public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private int uniqueId = 0;

    public void addSpellEvent(String eventType, String actionDescription) {
        uniqueId++;
        SpellEvent event = new SpellEvent(uniqueId, eventType, actionDescription);

        spellById.put(uniqueId, event);
        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(event);

    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, Collections.emptyList());
    }

    public void deleteSpellEvent(int id) {
        SpellEvent event = spellById.remove(id);
        if (event != null) {
            spellsByType.get(event.getEventType()).remove(event);
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            SpellEvent event = entry.getValue();
            System.out.println("ID: " + event.getId() +
                    ", Тип: " + event.getEventType() +
                    ", Действие: " + event.getAction());
        }
    }
}