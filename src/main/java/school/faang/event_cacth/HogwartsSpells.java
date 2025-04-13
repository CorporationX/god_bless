package school.faang.event_cacth;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private int currentId = 1;

    public void addSpellEvent(String eventType, String actionDescription) {
        int id = currentId++;
        spellById.put(id, buildSpellEvent(id, eventType, actionDescription));
        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(buildSpellEvent(id, eventType, actionDescription));
    }

    public void getSpellEventById(int id) {
        if (spellById.get(id) != null) {
            log.info("Найдено заклинание: {}.", spellById.get(id));
        } else {
            log.info("Заклинание под номером: {} не найдено.", id);
        }
    }

    public void getSpellEventsByType(String eventType) {
        if (spellsByType.get(eventType) != null) {
            log.info("Найдены заклинания: {} ", spellsByType.get(eventType));
        } else {
            log.info("Заклинания по типу {} не найдены.", eventType);
        }
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            List<SpellEvent> events = spellsByType.get(spellEvent.getEventType());
            if (events != null) {
                log.info("Заклинание: {} удалено.", spellEvent);
                events.remove(spellEvent);
            }
        } else {
            log.info("Заклинание под номером: {} не найдено.", id);
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    private SpellEvent buildSpellEvent(int id, String eventType, String actionDescription) {
        return SpellEvent.builder()
                .id(id)
                .eventType(eventType)
                .action(actionDescription).build();
    }
}
