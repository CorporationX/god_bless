package school.faang.spells;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class HogwartsSpells {
    private final AtomicInteger idCounter = new AtomicInteger(0);

    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public SpellEvent addSpellEvent(String eventType, String actionDescription) {
        Integer id = idCounter.getAndIncrement();
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(spellEvent);

        return spellEvent;
    }

    public Optional<SpellEvent> getSpellEventById(int id) {
        SpellEvent spellEvent = spellById.get(id);

        if (spellEvent == null) {
            return Optional.empty();
        } else {
            return Optional.of(spellEvent);
        }
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        spellById.remove(id);

        OUTER:
        for (Map.Entry<String, List<SpellEvent>> entry : spellsByType.entrySet()) {
            List<SpellEvent> spellList = entry.getValue();

            for (SpellEvent spellEvent : spellList) {
                if (spellEvent.getId() == id) {
                    spellList.remove(spellEvent);
                    break OUTER;
                }
            }
        }
    }

    public void printAllSpellEvents() {
        spellsByType.entrySet().forEach(System.out::println);
    }

}
