package school.faang.bjs44653;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellByType = new HashMap<>();
    private Map<Integer, Integer> spellIdToListId = new HashMap<>();

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spell = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spell);
        spellByType.computeIfAbsent(eventType, k -> new LinkedList<>());
        spellByType.get(eventType).add(spell);

        spellIdToListId.put(id, spellByType.get(eventType).size() - 1);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
            String spellType = spellById.remove(id).getSpellType();
            int listId = spellIdToListId.get(id);
            spellByType.get(spellType).remove(listId);
            spellIdToListId.remove(id);
    }

    public void printAllSpellEvents() {
        for (var spell : spellById.values()) {
            System.out.println(spell);
        }
    }
}
