package school.faang.bjs2_85909;

import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EqualsAndHashCode
public class HogwartsSpells {
    private final HashMap<Integer, SpellEvent> spellById = new HashMap<>();
    private final HashMap<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private int currentId = 1;

    public void addSpellEvent(String eventType, String actionDescription) {
        int id = currentId++;
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);

        spellById.put(id, spellEvent);
        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        if (spellById.get(id) != null) {
            return spellById.get(id);
        } else {
            throw new NullPointerException("Такого объекта нет.");
        }
    }

    public List<SpellEvent> getSpellEventByType(String eventType) {
        if (spellsByType.get(eventType) != null) {
            return spellsByType.get(eventType);
        } else {
            throw new NullPointerException("Такого объекта нет.");
        }
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent == null) {
            return;
        }
        
        List<SpellEvent> events = spellsByType.get(spellEvent.getEventType());
        if (events == null) {
            return;
        }

        events.remove(spellEvent);
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
