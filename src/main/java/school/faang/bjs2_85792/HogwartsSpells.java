package school.faang.bjs2_85792;

import ch.qos.logback.core.pattern.util.AlmostAsIsEscapeUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class HogwartsSpells {
    private HashMap<Integer, SpellEvent> spellById = new HashMap<>();
    private HashMap<EventType, List<SpellEvent>> spellByType = new HashMap<>();
    private int id;
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
        if (Objects.isNull(spellById.get(id))) {
            System.out.println("There is no such id");
            return;
        }

        EventType eventType = spellById.get(id).getEventType();
        List<SpellEvent> listEventType = spellByType.get(eventType);
        Optional<SpellEvent> spellEvent = listEventType.stream()
                .filter(sp -> Objects.equals(sp.getId(), id))
                .findFirst();
        if (Objects.nonNull(spellEvent)) {
            listEventType.remove(spellEvent.get());
        }
        spellByType.put(eventType, listEventType);
        spellById.remove(id);
    }

    public void printAllSpellEvents() {
        System.out.println("list events");
        System.out.println(spellById);
        System.out.println("List by spell type");
        System.out.println(spellByType);
    }
}
