package school.faang.bjs2_68757;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static school.faang.bjs2_68757.SpellEventIdCounter.getNextSpellEventId;

public class HogwartsSpells {
    private final Map<Long, SpellEvent> spellById = new HashMap<>();
    private final Map<SpellEventType, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(SpellEventType eventType, String actionDescription) {
        long spellId = getNextSpellEventId();
        SpellEvent spellEvent = new SpellEvent(spellId, eventType, actionDescription);
        spellById.put(spellEvent.id(), spellEvent);
        spellsByType.computeIfAbsent(eventType, value -> new ArrayList<>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(long id) {
        if (!spellById.containsKey(id)) {
            throw new SpellEventNotFoundException("Spell event with id " + id + " not found");
        }
        return this.spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(SpellEventType eventType) {
        List<SpellEvent> eventSpells = spellsByType.get(eventType);
        if (eventSpells == null) {
            throw new TypeSpellEventNotFoundException("Type spell event " + eventType + " not found");
        }
        return eventSpells;
    }

    public void deleteSpellEvent(long id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent == null) {
            throw new SpellEventNotFoundException("Spell event with id " + id + " not found");
        }
        List<SpellEvent> spellEvents = spellsByType.get(spellEvent.type());
        spellEvents.removeIf(event -> event.id() == id);
    }

    public void printAllSpellEvents() {
        spellById.entrySet().forEach(System.out::println);
    }
}
