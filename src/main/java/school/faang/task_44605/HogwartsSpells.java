package school.faang.task_44605;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<Type, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(SpellEvent event) {
        if (event == null) {
            throw new IllegalArgumentException("Can't add null event");
        }
        spellById.put(event.getId(), event);

        List<SpellEvent> events = spellsByType.computeIfAbsent(event.getEventType(), (p) -> new ArrayList<>());
        events.add(event);
        log.info(event + " was successfully added");
    }

    public SpellEvent getSpellEventById(int id) {
        SpellEvent event = spellById.get(id);
        if (event == null) {
            throw new IllegalArgumentException("There is no spell by " + id + " id");
        }
        return event;
    }

    public List<SpellEvent> getSpellEventsByType(Type eventType) {
        if (eventType == null) {
            throw new IllegalArgumentException("Can't find null event");
        }
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spell = spellById.remove(id);
        if (spell == null) {
            throw new IllegalArgumentException("There is no spell with " + id + " id");
        }

        List<SpellEvent> spells = spellsByType.get(spell.getEventType());
        spells.remove(spell);
        log.info(spell + " was successfully deleted");
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> spell : spellById.entrySet()) {
            System.out.println(spell.getValue());
        }
    }
}
