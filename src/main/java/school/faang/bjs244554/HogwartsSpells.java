package school.faang.bjs244554;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@ToString
public class HogwartsSpells {

    private Map<Integer, SpellEvent> spellById;
    private Map<String, List<SpellEvent>> spellsByType;

    public HogwartsSpells(Map<Integer, SpellEvent> spellById,
                          Map<String, List<SpellEvent>> spellsByType) {
        this.spellById = spellById;
        this.spellsByType = spellsByType;
    }

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellsByType.computeIfAbsent(actionDescription, k -> new ArrayList<>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spell = spellById.remove(id);
        if (Objects.nonNull(spell)) {
            spellsByType.get(spell.getEventType()).remove(spell);
        }
    }

    public void printAllSpellEvents() {
        for (var entry : spellById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

}
