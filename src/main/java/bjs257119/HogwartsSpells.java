package bjs257119;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Getter
public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private static int globalId = 0;

    void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(++globalId, eventType, actionDescription);
        spellById.put(spellEvent.getId(), spellEvent);

        Optional.ofNullable(spellsByType.get(eventType))
                .ifPresentOrElse(events -> events.add(spellEvent), () -> {
                    List<SpellEvent> spellEvents = new ArrayList<>();
                    spellsByType.put(eventType, spellEvents);
                });
    }

    SpellEvent getSpellEventById(int id) {
        return Optional.ofNullable(spellById.get(id))
                .orElseThrow(() -> new IllegalArgumentException("Wrong id"));
    }

    List<SpellEvent> getSpellEventsByType(String eventType) {
        return Optional.ofNullable(spellsByType.get(eventType))
                .orElseThrow(() -> new IllegalArgumentException("Wrong type"));
    }

    void deleteSpellEvent(int id) {
        SpellEvent spellEvent = Optional.ofNullable(spellById.get(id))
                .orElseThrow(() -> new IllegalArgumentException("Wrong id"));
        List<SpellEvent> spellEvents = Optional.ofNullable(spellsByType.get(spellEvent.getEventType()))
                .orElseThrow(() -> new IllegalArgumentException("Wrong type"));
        spellEvents.remove(spellEvent);
        spellById.remove(id);
    }

    void printAllSpellEvents() {
        spellById.forEach((key, value) -> System.out.printf("ID: %d, Event type: %s, Action: %s %n",
                value.getId(), value.getEventType(), value.getAction()));
    }
}
