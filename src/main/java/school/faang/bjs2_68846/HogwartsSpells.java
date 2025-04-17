package school.faang.bjs2_68846;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        int eventId = (eventType + actionDescription).hashCode();

        SpellEvent spellEvent = spellById.computeIfAbsent(
                eventId, key -> new SpellEvent(eventId, eventType, actionDescription));

        List<SpellEvent> eventList = spellsByType.computeIfAbsent(eventType, key -> new ArrayList<>());
        if (!eventList.contains(spellEvent)) {
            eventList.add(spellEvent);
        }
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            spellsByType.get(spellEvent.eventType()).remove(spellEvent);
        }
    }

    public void printAllSpellEvents() {
        System.out.println("\nВсе доступные заклинания:");
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.printf("ID: %d, type: %s, action: %s%n",
                    entry.getValue().id(), entry.getValue().eventType(), entry.getValue().action());
        }
    }
}
