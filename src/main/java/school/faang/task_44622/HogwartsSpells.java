package school.faang.task_44622;

import java.util.*;

public class HogwartsSpells {
    private static Map<Integer, SpellEvent> spellById = new HashMap<>();
    private static Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public static void addSpellEvent(int id, String eventType, String actionDescription) {
        var spellEvent = new SpellEvent(id, eventType, actionDescription);
        if (spellById.containsKey(spellEvent.getId())) {
            throw new IllegalArgumentException("Заклинание с ID " + spellEvent.getId() + " уже существует");
        }
        spellById.put(spellEvent.getId(), spellEvent);
        List<SpellEvent> spells = spellsByType.computeIfAbsent(spellEvent.getEventType(), k -> new ArrayList<>());
        spells.add(spellEvent);
    }

    public static SpellEvent getSpellEventById(int id) {
        return Optional.ofNullable(spellById.get(id))
                .orElseThrow(() -> new IllegalArgumentException("Заклинание с ID " + id + " не существует"));
    }

    public static List<SpellEvent> getSpellEventsByType(String eventType) {
        List<SpellEvent> spells = spellsByType.get(eventType);
        if (spells == null) {
            throw new IllegalArgumentException("События с типом " + eventType + " не существуют");
        }
        return spells;
    }

    public static void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent == null) {
            throw new IllegalArgumentException("Заклинание с ID " + id + " не существует");
        }
        List<SpellEvent> spells = spellsByType.get(spellEvent.getEventType());
        spells.remove(spellEvent);
    }

    public static void printAllSpellEvents() {
        spellById.forEach((id, event) ->
                System.out.printf("ID: %d | Тип: %s | Действие: %s%n", id, event.getEventType(), event.getAction()));
    }
}