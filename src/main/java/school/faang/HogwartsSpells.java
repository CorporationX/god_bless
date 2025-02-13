package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class HogwartsSpells {

    private static int currentId = 0;

    Map<Integer, SpellEvent> spellById = new HashMap<>();
    Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(currentId++, eventType, actionDescription);
        spellById.put(currentId, spellEvent);
        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        if (id < 0 || id >= spellById.size()) {
            throw new IllegalArgumentException("Заклинания с таким ID нет: " + id);
        }
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventByType(String eventType) {
        if (eventType.isBlank() || !spellsByType.containsKey(eventType)) {
            throw new IllegalArgumentException("Такое заклинание не найдено: " + eventType);
        }
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        if (id < 0 || id >= spellById.size()) {
            throw new IllegalArgumentException("Заклинания с таким ID нет: ");
        }
        SpellEvent removedSpell = spellById.remove(id);
        if (removedSpell != null) {
            List<SpellEvent> spellEvents = spellsByType.get(removedSpell.getEventType());
            if (spellEvents != null) {
                spellEvents.remove(removedSpell);
            }
        }
    }

    public void printAllSpellEvents() {
        for (var entry : spellById.entrySet()) {
            System.out.printf("ID заклинания: %s \nТип заклинания: %s \nДействие заклинания: %s\n",
                    entry.getKey(), entry.getValue().getEventType(), entry.getValue().getAction());
        }
    }
}
