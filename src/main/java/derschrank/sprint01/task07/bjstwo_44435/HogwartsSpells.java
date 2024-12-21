package derschrank.sprint01.task07.bjstwo_44435;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<Spell, List<SpellEvent>> spellByType = new HashMap<>();

    public int addSpellEvent(Spell spell) {
        SpellEvent spellEvent = new SpellEvent(spell);
        spellById.put(spellEvent.getId(), spellEvent);

        spellByType.computeIfAbsent(spell, k -> new ArrayList<>())
                .add(spellEvent);

        return spellEvent.getId();
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(Spell spell) {
        return spellByType.get(spell);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);

        if (spellEvent != null) {
            List<SpellEvent> list = spellByType.get(spellEvent.getEventType());
            list.remove(spellEvent);
            if (list.isEmpty()) {
                spellByType.remove(spellEvent.getEventType());
            }
        }
    }

    public void printAllSpellEvents() {
        System.out.println(this);
    }

    public void printAllSpellEventsByType(Spell spell) {
        StringBuilder result = new StringBuilder("Log events of ");
        result.append(spell);
        result.append(":\n");

        for (SpellEvent spellEvent : getSpellEventsByType(spell)) {
            result.append(spellEvent);
            result.append("\n");
        }

        System.out.println(result);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Log events of spells:\n");

        for (SpellEvent spellEvent : spellById.values()) {
            result.append(spellEvent);
            result.append("\n");
        }

        return result.toString();
    }

    public int getSize() {
        return spellById.size();
    }
}
