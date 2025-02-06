package task_BJS2_57002;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class HogwartsSpells {
    public final Map<Integer, SpellEvent> spellById = new HashMap<>();
    public final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private int id = 0;

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            List<SpellEvent> events = spellsByType.get(spellEvent.getEventType());
            if (events.size() > 1) {
                events.remove(spellEvent);
            } else {
                spellsByType.remove(spellEvent.getEventType());
                System.out.print("В вашем арсенале больше нет заклинаний");
            }
        }
    }

    public void printAllSpellEvents() {
        for (var entry : spellById.entrySet()) {
            System.out.printf("Заклинание \"%s\" по id \"%d\" %s\n", entry.getValue().getEventType(),
                    entry.getValue().getId(), entry.getValue().getAction());
        }
    }

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);

        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);

        id++;
    }

}
