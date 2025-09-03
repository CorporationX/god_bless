package school.faang.bjs2_85763;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {

    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    // spellById: HashMap для хранения событий заклинаний по их ID.
    // Ключ — Integer (ID события), значение — SpellEvent;
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    // spellsByType: HashMap для хранения списка событий заклинаний по их типу.
    // Ключ — String (тип события), значение — List<SpellEvent>.
    private int currentId = 1;

    public void addSpellEvent(String eventType, String actionDescription) {
        int id = currentId++; // генерируем уникальный id
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);

        spellById.put(id, spellEvent);

        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            List<SpellEvent> events = spellsByType.get(spellEvent.getEventType());
            if (events != null) {
                events.remove(spellEvent);
            }
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println("Ключ: " + entry.getKey() + ", Значение: " + entry.getValue());
        }
    }
}