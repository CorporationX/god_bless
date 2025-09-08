package school.faang.module1.spells;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class HogwartsSpells {
    private final AtomicInteger idCounter = new AtomicInteger(0);
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<EventType, List<SpellEvent>> spellsByType = new HashMap<>();
    private final Map<Integer, EventType> spellTypeById = new HashMap<>();

    public SpellEvent addSpellEvent(EventType eventType, String actionDescription) {
        Integer id = idCounter.getAndIncrement();
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(spellEvent);
        spellTypeById.put(spellEvent.getId(), spellEvent.getEventType());

        return spellEvent;
    }

    public Optional<SpellEvent> getSpellEventById(int id) {
        SpellEvent spellEvent = spellById.get(id);

        return Optional.ofNullable(spellEvent);
    }

    public List<SpellEvent> getSpellEventsByType(EventType eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent == null) {
            return;
        }

        EventType type = spellTypeById.remove(id);
        List<SpellEvent> spellList = spellsByType.get(type);

        if (spellList != null) {
            spellList.remove(spellEvent);
            if (spellList.isEmpty()) {
                spellsByType.remove(type);
            }
        }
    }

    public void printAllSpellEvents() {
        spellsByType.entrySet().forEach(System.out::println);
    }

}
