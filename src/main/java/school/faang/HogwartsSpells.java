package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    Map<Integer, SpellEvent> spellById = new HashMap<>();
    Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    Integer id = 0;
    public void addSpellEvent(String eventType, String actionDescription) {

        spellById.put(id, new SpellEvent(id, eventType, actionDescription));

        spellsByType.computeIfAbsent(eventType, s -> List.of());
        List<SpellEvent> spellEvents = spellsByType.get(eventType);
        spellEvents.add(new SpellEvent(id, eventType, actionDescription));
        spellsByType.put(eventType, spellEvents);
        id++;
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        spellById.remove(id);
        for (Map.Entry<String, List<SpellEvent>> entry : spellsByType.entrySet()) {
            entry.getValue().stream()
                    .filter(l -> l.getId() == id)
                    .findFirst().ifPresent(spellEvent -> entry.getValue().remove(spellEvent));
        }
    }

    public void printAllSpellEvents() {
        spellById.forEach((key, value) -> System.out.println("id: " + value.getId() + " тип: " + value.getEventType() + " действие " + value.getAction()));
    }
}
