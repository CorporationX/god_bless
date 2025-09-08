package school.faang.bjs2_85872;

import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private int currentId = 1;

    public void addSpellEvent(String eventType, String actionDescription) {
        int id = currentId++;
        SpellEvent newEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, newEvent);

        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(newEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        if (id < 0) {
            return null;
        }
        SpellEvent value = spellById.get(id);
        return value;
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        List<SpellEvent> spells = spellsByType.get(eventType);

        if (spells == null) {
            return null;
        }
        return spells;
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellRemove = spellById.get(id);
        if (spellRemove != null) {
            List<SpellEvent> spellList = spellsByType.get(spellRemove.getEventType());
            spellById.remove(id);
            if (spellList != null) {
                spellList.remove(spellRemove);
                if (spellList.isEmpty()) {
                    spellsByType.remove(spellRemove.getEventType());
                }
            }
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println("ID " + entry.getKey() + " тип " + entry.getValue().getEventType() + " значение " + entry.getValue().getAction());
        }
    }
}
