package school.faang.sprint1.task44660lovim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EqualsAndHashCode
public class HogwartsSpells {
    public static Map<Integer, SpellEvent> spellById = new HashMap<>();
    public static Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public static void addSpellEvent(int id, String eventType, String actionDescription) {
        var spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);

        if (spellsByType.get(eventType) == null) {
            spellsByType.put(eventType, new ArrayList<>());
            spellsByType.get(eventType).add(spellEvent);
        } else {
            spellsByType.get(eventType).add(spellEvent);
        }
    }

    public static SpellEvent getSpellEventById(int id) {
        SpellEvent spellEvent = spellById.get(id);
        if (spellEvent == null) {
            log.warn("Спелл с id {} не существует", id);
            return null;
        }
        return spellEvent;
    }

    public static List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public static void deleteSpellEvent(int id) {
        SpellEvent removed = spellById.remove(id);
        if (removed == null) {
            log.warn("Спелл с id {} не найден", id);
            return;
        }

        List<SpellEvent> spellsEvent = spellsByType.get(removed.getEventType());
        if (spellsEvent != null) {
            var iterator = spellsEvent.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().getId() == id) {
                    iterator.remove();
                }
            }
        }
        System.out.println("Спелл удален");
    }

    public static void printAllSpellEvents() {
        if (spellById.isEmpty()) {
            log.info("Нет доступных спеллов");
            return;
        }
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            var spellEvent = entry.getValue();
            int id = entry.getKey();
            String action = spellEvent.getAction();
            String eventType = spellEvent.getEventType();
            System.out.printf("id: %d | action: %s | eventType: %s%n", id, action, eventType);
        }
    }

}
