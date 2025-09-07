package school.faang;

import java.util.ArrayList;
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

        if (!spellsByType.containsKey(eventType)) {
            spellsByType.put(eventType, new ArrayList<SpellEvent>());
        }

        spellsByType.get(eventType).add(spellEvent);
    }

    public String getSpellEventById(int id) {
        if (!spellById.containsKey(id)) {
            return null;
        }
        return spellById.get(id).getEventType();
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {

        List<SpellEvent> listEvent = spellsByType.get(eventType);
        if (listEvent == null) {
            return List.of();
        }
        return List.copyOf(listEvent);
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
