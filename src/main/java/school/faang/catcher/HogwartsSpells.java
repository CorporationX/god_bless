package school.faang.catcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private int countId;

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(countId, eventType, actionDescription);
        spellById.put(countId, spellEvent);
        spellsByType.computeIfAbsent(eventType, u -> new ArrayList<>()).add(spellEvent);
        countId++;
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public void deleteSpellEvent(int id) {
        if (!spellById.containsKey(id)) {
            System.out.println("Заклинания с таким id не существует");
            return;
        }
        SpellEvent spell = spellById.remove(id);
        String spellType = spell.getEventType();

        List<SpellEvent> spellsOfType = spellsByType.get(spellType);
        if (spellsOfType != null) {
            spellsOfType.remove(spell);

            if (spellsOfType.isEmpty()) {
                spellsByType.remove(spellType);
                System.out.println("Удалено последнее заклинание типа " + spellType);
                spellsByType.remove(spellType);
            }
        }
    }

    public void printAllSpellEvents() {
        for (var spellEntry : spellById.entrySet()) {
            System.out.println(spellEntry.getValue());
        }
    }

}
