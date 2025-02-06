package school.BJS57042;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class HogwartsSpells {
    HashMap<Integer, SpellEvent> spellById = new HashMap<>();
    HashMap<String, List<SpellEvent>> spellsByType = new HashMap<>();

    /**
     * @param eventType - тип события
     *
     * @param action - что делает это событие
     * <p>
     * метод addSpellEvent генерирует уникальный id путем поиска максимально значения ключей,
     * после чего добавляет событие в 2 мары
     */
    public void addSpellEvent(String eventType, String action) {
        // Генерация уникального идентификатора для нового события
        int id = spellById.isEmpty() ? 1 : Collections.max(spellById.keySet()) + 1;
        SpellEvent spellEvent = new SpellEvent(id, eventType, action);
        // Добавление события в мапу по идентификатору
        spellById.put(id, spellEvent);
        System.out.println("SpellEvent added: " + spellEvent + ", ID: " + id);
        // Добавление события по типу
        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(spellEvent);
    }

    public void getSpellEventById(int id) {
        if (spellById.containsKey(id)) {
            System.out.println("Your spell Event ----> " + spellById.get(id));
        } else {
            System.out.println("Your spell Event not found ");
        }
    }

    public void getSpellEventsByType(String eventType) {
        System.out.println("Type: " + eventType + " || Events: " + spellsByType.get(eventType) + "\n");
    }

    /**
     *
     * в методе deleteSpellEvent проверяем на наличие события по переданному id,
     * полсе чего удаляем из мапы spellById и ищем событие в мапе spellsByType,
     * если оно != null - удаляем
     */
    public void deleteSpellEvent(int id) {
        System.out.println("Your spell Event ----> " + spellById.get(id));
        if (spellById.containsKey(id)) {
            SpellEvent spellEvent = spellById.remove(id);
            List<SpellEvent> events = spellsByType.get(spellEvent.getEventType());
            if (events != null) {
                events.remove(spellEvent);
                System.out.println("delete event successfully ");
            }
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
