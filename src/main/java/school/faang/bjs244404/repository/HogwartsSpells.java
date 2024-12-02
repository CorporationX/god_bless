package school.faang.bjs244404.repository;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import school.faang.bjs244404.model.SpellEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@EqualsAndHashCode
public class HogwartsSpells {

    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        if (this.spellById.containsKey(id)) {
            throw new IllegalArgumentException("This id is used");
        }
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        this.spellById.put(id, spellEvent);

        List<SpellEvent> spellEventList = this.spellsByType.computeIfAbsent(eventType, list -> new ArrayList<>());
        spellEventList.add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return this.spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return this.spellsByType.get(eventType);
    }

    public SpellEvent deleteSpellEvent(int id) {
        SpellEvent spellEvent = this.spellById.get(id);
        this.spellById.remove(id);
        this.spellsByType.get(spellEvent.getEventType()).removeIf(spell -> spell.getId() == id);
        return spellEvent;
    }

    public void printAllSpellEvents() {
        System.out.println(this.spellById.entrySet());
    }
}
