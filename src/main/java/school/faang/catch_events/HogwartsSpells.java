package school.faang.catch_events;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<Enum, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(int id, Enum eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        SpellEvent spellEvent = spellById.get(id);
        if (spellEvent == null) {
            log.error("WARNING SPELL ID NOT FOUND");
            throw new SpellNotFoundException(id);
        } else {
            return spellEvent;
        }
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        try {
            List<SpellEvent> spellEvents = spellsByType.get(Enum.valueOf(EventType.class, eventType));
            if (spellEvents == null) {
                log.error("WARNING EVENT NOT FOUND");
                throw new EventNotFoundException(eventType);
            }
            return spellEvents;
        } catch (RuntimeException e) { //ловим исключение от метода Enum.valueOf()
            log.error("WARNING EVENT ID NOT FOUND");
            throw new EventNotFoundException(eventType);
        }
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent == null) {
            log.error("WARNING SPEll NOT FOUND");
            throw new SpellNotFoundException(id);
        } else {
            List<SpellEvent> events = spellsByType.get(spellEvent.getEventType());
            events.remove(spellEvent);
            System.out.println("Spell with id " + id + " was deleted");
        }
    }

    public void printAllSpellEvents() {
        spellById.forEach((id, spellEvent) -> System.out.println(id + " " + spellEvent));
    }
}
