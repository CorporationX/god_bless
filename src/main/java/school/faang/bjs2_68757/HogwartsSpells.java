package school.faang.bjs2_68757;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static school.faang.bjs2_68757.SpellEventIdCounter.getNextSpellEventId;

public class HogwartsSpells {
    private final Map<Long, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(getNextSpellEventId(), eventType, actionDescription);
        this.spellById.put(spellEvent.id(), spellEvent);
        List<SpellEvent> spellEvents = this.spellsByType.getOrDefault(eventType, new ArrayList<>());
        spellEvents.add(spellEvent);
        this.spellsByType.put(eventType, spellEvents);
    }

    public SpellEvent getSpellEventById(long id) {
        if (!this.spellById.containsKey(id)) {
            throw new SpellEventNotFoundException("Spell event with id " + id + " not found");
        }
        return this.spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        if (!this.spellsByType.containsKey(eventType)) {
            throw new TypeSpellEventNotFoundException("Type spell event " + eventType + " not found");
        }
        return this.spellsByType.get(eventType);
    }

    public void deleteSpellEvent(long id) {
        if (!this.spellById.containsKey(id)) {
            throw new SpellEventNotFoundException("Spell event with id " + id + " not found");
        }
        SpellEvent spellEvent = this.spellById.remove(id);
        List<SpellEvent> spellEvents = this.spellsByType.get(spellEvent.type());
        spellEvents.remove(spellEvent);
    }

    public void printAllSpellEvents() {
        this.spellById.entrySet().forEach(System.out::println);
    }
}
