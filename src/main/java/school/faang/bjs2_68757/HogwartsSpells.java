package school.faang.bjs2_68757;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static school.faang.bjs2_68757.SpellEventIdCounter.getNextSpellEventId;

public class HogwartsSpells {
    private final Map<Long, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private final Map<Long, Integer> indexSpellById = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        long spellId = getNextSpellEventId();
        SpellEvent spellEvent = new SpellEvent(spellId, eventType, actionDescription);
        spellById.put(spellEvent.id(), spellEvent);
        spellsByType.computeIfAbsent(eventType, value -> new ArrayList<>()).add(spellEvent);
        indexSpellById.put(spellId, spellsByType.get(eventType).size() - 1);
    }

    public SpellEvent getSpellEventById(long id) {
        if (!spellById.containsKey(id)) {
            throw new SpellEventNotFoundException("Spell event with id " + id + " not found");
        }
        return this.spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        if (!spellsByType.containsKey(eventType)) {
            throw new TypeSpellEventNotFoundException("Type spell event " + eventType + " not found");
        }
        return this.spellsByType.get(eventType);
    }

    public void deleteSpellEvent(long id) {
        if (!this.spellById.containsKey(id)) {
            throw new SpellEventNotFoundException("Spell event with id " + id + " not found");
        }
        // TODO: выполнится ли этот код, после исключения
        SpellEvent spellEvent = spellById.remove(id);
        int indexSpell = indexSpellById.remove(id);
        // TODO: нужно пробежаться по всем id, которые относятся к нужному типу и их индекс больше и уменьшить на 1
        List<SpellEvent> spellEvents = spellsByType.get(spellEvent.type());
        spellEvents.remove(indexSpell);
    }

    public void printAllSpellEvents() {
        spellById.entrySet().forEach(System.out::println);
    }
}
