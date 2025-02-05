package school.faang.catch_the_event;

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
        spellsByType.putIfAbsent(spellEvent.getEventType(), new ArrayList<>());
        spellsByType.get(spellEvent.getEventType()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        checkId(id);
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        if (eventType == null || eventType.isBlank()) {
            throw new IllegalArgumentException("Тип заклинания не может быть пустым или null");
        }
        if (!spellsByType.containsKey(eventType)) {
            throw new IllegalArgumentException("По данному типу заклинаний нет");
        }

        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        checkId(id);
        spellById.remove(id);
        spellsByType.remove(spellById.get(id).getEventType());
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println("id - %d, тип - %s, данные события - %s".formatted(
                    entry.getKey(), entry.getValue().getEventType(), entry.getValue()));
        }
    }

    private void checkId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("id не может быть отрицательным");
        }
        if (!spellById.containsKey(id)) {
            throw new IllegalArgumentException("События с id %d не существует".formatted(id));
        }
    }
}
