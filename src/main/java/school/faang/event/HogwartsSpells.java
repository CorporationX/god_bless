package school.faang.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {

    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private int id = 0;

    public void addSpellEvent(String eventType, String actionDescription) {
        spellById.put(id, new SpellEvent(id, eventType, actionDescription));
        spellsByType
                .computeIfAbsent(eventType, a -> new ArrayList<>())
                .add(new SpellEvent(id, eventType, actionDescription));
        id++;
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        spellsByType.get(spellById.get(id).getEventType()).remove(spellById.get(id));
        spellById.remove(id);
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.printf(
                    "id: %s\nSpell type: %s\nAction: %s%n",
                    entry.getKey(),
                    entry.getValue().getEventType(),
                    entry.getValue().getAction()
            );
        }
    }
}
