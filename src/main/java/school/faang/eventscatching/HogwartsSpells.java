package school.faang.eventscatching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(eventType, actionDescription);
        spellById.put(spellEvent.getId(), spellEvent);
        spellsByType.computeIfAbsent(eventType, key -> new ArrayList<>()).add(spellEvent);
        System.out.println("Событие заклинаний успешно добавлено: " + spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        if (id < 1) {
            throw new IllegalArgumentException("Id не может быть меньше 1!");
        }
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        if (eventType != null && !eventType.isBlank()) {
            return spellsByType.getOrDefault(eventType, new ArrayList<>());
        }
        throw new IllegalArgumentException("Категория для поиска не может быть пустой!");
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            System.out.println("Событие заклинаний успешно удалено: " + spellEvent);
            List<SpellEvent> events = spellsByType.get(spellEvent.getEventType());
            if (events != null) {
                events.remove(spellEvent);
            }
            return;
        }
        System.out.printf("Событие заклинаний c id %d не найдено.", id);
    }

    public void printAllSpellEvents() {
        System.out.println("Список заклинаний:");
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
