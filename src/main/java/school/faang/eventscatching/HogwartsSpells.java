package school.faang.eventscatching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

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
        SpellEvent event  = spellById.get(id);
        if (event != null) {
            return event;
        }
        throw new NoSuchElementException("Не найдено событие заклинаний для ID: " + id);

    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        if (eventType != null && !eventType.isBlank()) {
            return spellsByType.getOrDefault(eventType, new ArrayList<>());
        }
        throw new IllegalArgumentException("Категория для поиска не может быть пустой!");
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent == null) {
            System.out.printf("Событие заклинаний c id %d не найдено.%n", id);
            return;
        }
        List<SpellEvent> events = spellsByType.get(spellEvent.getEventType());
        if (events != null) {
            events.remove(spellEvent);
            System.out.println("Событие заклинаний успешно удалено: " + spellEvent);
        }
    }

    public void printAllSpellEvents() {
        System.out.println("Список заклинаний:");
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            SpellEvent spellEvent = entry.getValue();
            System.out.printf("Тип - %s\t\tДействие - %s\n", spellEvent.getEventType(), spellEvent.getAction());
        }
    }
}
