package school.faang.BJS2_85802;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;


public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private final AtomicInteger idSeq = new AtomicInteger(1);


    public void addSpellEvent(String eventType, String actionDescription) {

        int nextSpellId = idSeq.getAndIncrement();

        SpellEvent spellEvent = new SpellEvent(nextSpellId, eventType, actionDescription);
        spellById.put(nextSpellId, spellEvent);

        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);

    }

    public SpellEvent getSpellEventById(int id) {
        if (!spellById.containsKey(id)) {
            return null;
        }
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, Collections.emptyList());
    }

    public void deleteSpellEvent(int id) {

        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent == null) {
            throw new NoSuchElementException("SpellEvent не найден по id=" + id);
        }

        String eventType = spellEvent.getEventType();
        spellsByType.get(eventType).remove(spellEvent);
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }


}
