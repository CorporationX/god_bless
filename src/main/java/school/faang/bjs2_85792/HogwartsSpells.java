package school.faang.bjs2_85792;

import ch.qos.logback.core.pattern.util.AlmostAsIsEscapeUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class HogwartsSpells {
    private final HashMap<Integer, SpellEvent> spellById = new HashMap<>();
    private final HashMap<EventType, List<SpellEvent>> spellByType = new HashMap<>();
    AtomicCounter atomicCounter = new AtomicCounter();

    public void addSpellEvent(EventType eventType, String actionDescription) {
        int idTemp = atomicCounter.incrementId();
        SpellEvent spellEvent = new SpellEvent(idTemp, eventType, actionDescription);
        spellById.put(idTemp, spellEvent);

        spellByType.computeIfAbsent(eventType, arr -> new ArrayList<>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEventById = spellById.get(id);
        if (Objects.isNull(spellEventById)) {
            System.out.println("There is no such id");
            return;
        }

        EventType eventType = spellEventById.getEventType();
        List<SpellEvent> listEventType = spellByType.get(eventType);
        Optional<SpellEvent> spellEvent = listEventType.stream()
                .filter(sp -> Objects.equals(sp.getId(), id))
                .findFirst();
        if (Objects.nonNull(spellEvent)) {
            listEventType.remove(spellEvent.get());
        }
        spellById.remove(id);
    }

    public void printAllSpellEvents() {
        System.out.println("list events");
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
