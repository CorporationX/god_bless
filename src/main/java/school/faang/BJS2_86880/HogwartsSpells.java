package school.faang.BJS2_86880;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private static final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private static final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public static void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent newSpellEvent = new SpellEvent(eventType, actionDescription);
        spellById.put(newSpellEvent.getId(), newSpellEvent);
        List<SpellEvent> thisTypeSpells = new ArrayList<>();
        spellsByType.putIfAbsent(newSpellEvent.getEventType(), thisTypeSpells);
        spellsByType.get(newSpellEvent.getEventType()).add(newSpellEvent);
    }

    public static SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public static List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public static void deleteSpellEvent(int id) {
        String thisSpellEventType = spellById.get(id).getEventType();
        spellById.remove(id);
        spellsByType.get(thisSpellEventType).removeIf(spellEvent -> spellEvent.getId() == id);

    }

    public static void printAllSpellEvents() {
        spellById.forEach((id, spellEvent) -> System.out.printf(
                "id %d, тип: %s, действие: %s", id, spellEvent.getEventType(), spellEvent.getAction()));
    }
}
