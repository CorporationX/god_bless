package school.faang.bjs2_69898;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<EventType, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(EventType eventType, String actionDescription) {
        var event = new SpellEvent(eventType, actionDescription);
        spellById.put(event.id(), event);

        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(event);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.getOrDefault(id, null);
    }

    public List<SpellEvent> getSpellEventsByType(EventType eventType) {
        return spellsByType.getOrDefault(eventType, Collections.emptyList());
    }

    public void deleteSpellEvent(int id) {
        var removedSpell = spellById.remove(id);
        if (removedSpell == null) {
            log.warn("Событие с ID {} не найдено", id);
            return;
        }

        var spellEvents = spellsByType.get(removedSpell.eventType());
        if (spellEvents != null) {
            spellEvents.remove(removedSpell);
        }
    }

    public void printAllSpellEvents() {
        spellById.forEach((id, spell) -> System.out.println("ID: " + id + ", " + spell));
    }
}