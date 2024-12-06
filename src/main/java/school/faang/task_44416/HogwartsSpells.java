package school.faang.task_44416;

import java.util.*;

public class HogwartsSpells {
    Map<Integer, SpellEvent> spellById = new HashMap<Integer, SpellEvent>();
    Map<String, List<SpellEvent>> spellsByType = new HashMap<String, List<SpellEvent>>();

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.computeIfAbsent(id, k -> spellEvent);
        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<SpellEvent>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        spellById.remove(id);
        for (String eventType, List<SpellEvent> : spellsByType) {

        }
    }
}
