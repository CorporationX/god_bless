package school.faang.bjs2_79669;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private Map<Long, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellByType = new HashMap<>();

    private static Long countId = 0L;

    public void addSpellEvent(String eventType, String actionDescription) {
        Long currentId = generateId();
        SpellEvent spellEvent = new SpellEvent(currentId, eventType, actionDescription);

        spellById.put(currentId, spellEvent);
        spellByType.computeIfAbsent(eventType, key -> new ArrayList<>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(Long id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventByType(String eventType) {
        return spellByType.getOrDefault(eventType, new ArrayList<>());
    }

    public void deleteSpellEvent(Long id) {
        SpellEvent removedSpell = spellById.remove(id);
        if (removedSpell == null) {
            return;
        }

        String eventType = removedSpell.getEventType();
        List<SpellEvent> spells = spellByType.get(eventType);

        if (spells != null) {
            spells.remove(removedSpell);

            if (spells.isEmpty()) {
                spellByType.remove(eventType);
            }
        }
    }

    public void printAllSpellEvents() {
        for (var entry : spellById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    private static Long generateId() {
        return countId++;
    }
}
