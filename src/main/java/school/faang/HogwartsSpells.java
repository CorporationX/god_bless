package school.faang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById;
    private final Map<String, List<SpellEvent>> spellsByType;

    public HogwartsSpells() {
        this.spellById = new HashMap<>();
        this.spellsByType = new HashMap<>();
    }

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent newSpell = new SpellEvent(id, eventType, actionDescription);

        spellById.put(id, newSpell);

        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(newSpell);

        System.out.println("Заклинание добавлено: " + newSpell);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, Collections.emptyList());
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellToRemove = spellById.remove(id);

        if (spellToRemove != null) {
            List<SpellEvent> eventsByType = spellsByType.get(spellToRemove.getEventType());
            if (eventsByType != null) {
                eventsByType.remove(spellToRemove);
                if (eventsByType.isEmpty()) {
                    spellsByType.remove(spellToRemove.getEventType());
                }
            }
            System.out.println("Заклинание удалено: " + spellToRemove);
        } else {
            System.out.println("Заклинание с ID " + id + " не найдено.");
        }
    }

    public void printAllSpellEvents() {
        if (spellById.isEmpty()) {
            System.out.println("Заклинаний нет.");
        } else {
            System.out.println("Список всех заклинаний:");
            for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
                System.out.println("ID: " + entry.getKey() + ", Заклинание: " + entry.getValue());
            }
        }
    }
}
