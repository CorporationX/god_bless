package school.faang.bjs2_79669;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class HogwartsSpells {
    static Map<Long, SpellEvent> spellById = new HashMap<>();
    static Map<String, List<SpellEvent>> spellByType = new HashMap<>();

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
        return spellByType.get(eventType);
    }

    public void deleteSpellEvent(Long id) {
        spellById.remove(id);

        for (var entry : spellByType.entrySet()) {
            List<SpellEvent> spells = entry.getValue();
            for (SpellEvent spell : spells) {
                if (Objects.equals(spell.getId(), id)) {
                    spells.remove(spell);
                    break;
                }
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
