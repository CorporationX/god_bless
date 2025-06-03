package school.faang.bjs2_79663;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Slf4j
public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        int id = generateId();
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);

        spellById.put(id, spellEvent);
        spellsByType.computeIfAbsent(eventType, (event) -> new ArrayList<>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public SpellEvent deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);

        if (spellEvent == null) {
            log.info("Не удалось удалить событие по id - {}", id);
            return null;
        }

        String eventType = spellEvent.eventType();
        boolean isRemoved = spellsByType.get(eventType).remove(spellEvent);

        if (!isRemoved) {
            log.info("Не удалось удалить событие по типу - {}", eventType);
            return null;
        }

        return spellEvent;
    }

    public void printAllSpellEvents() {
        for (var entrySet : spellById.entrySet()) {
            SpellEvent spellEvent = entrySet.getValue();
            System.out.println(spellEvent);
        }
    }

    private int generateId() {
        Random random = new Random();
        int id;

        do {
            id = random.nextInt(1, 6);
        } while (spellById.containsKey(id));

        return id;
    }
}
