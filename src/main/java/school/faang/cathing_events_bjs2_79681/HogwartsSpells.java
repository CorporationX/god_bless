package school.faang.cathing_events_bjs2_79681;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class HogwartsSpells {
    private HashMap<Integer, SpellEvent> spellById = new HashMap<>();
    private HashMap<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private int nextId = 0;

    public int generateId() {
        return nextId++;
    }

    public void addSpellEvent(String eventType, String actionDescription) {
        int id = generateId();
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);

        spellById.put(id, spellEvent);

        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        if (spellById.get(id) == null) {
            log.warn("Такого события нет");
            return null;
        } else {
            log.info("Событие по id: {}", spellById.get(id).toString());
            return spellById.get(id);
        }
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        List<SpellEvent> events = spellsByType.get(eventType);
        if (events == null) {
            log.warn("Такого элемента нет: {}", eventType);
            return Collections.emptyList();
        }
        System.out.printf("События по типу:\n", events);
        return events;
    }

    public void deleteSpellEvent(int id) {
        if (getSpellEventById(id) == null) {
            log.warn("Такого id нет");
        } else {
            log.info("Элемент {} удален", id);
            spellById.remove(id);
            spellsByType.remove(spellById.get(id));
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            Integer id = entry.getKey();
            SpellEvent spellEvent = entry.getValue();
            System.out.printf("id: %d \t value: %s\n", id, spellEvent);
        }
    }
}
