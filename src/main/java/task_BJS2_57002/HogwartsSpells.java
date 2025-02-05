package task_BJS2_57002;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class HogwartsSpells {
    public static final Map<Integer, SpellEvent> spellById = new HashMap<>();
    public static final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private static int id = 0;

    public static SpellEvent getSpellEventById(int id) {
        return spellById.getOrDefault(id, null);
    }

    public static List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, null);
    }

    public static void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            List<SpellEvent> events = spellsByType.get(spellEvent.getEventType());
            if (events != null) {
                events.remove(spellEvent);
            }
        }
    }

    public static void printAllSpellEvents() {

        for (var entry : spellById.entrySet()) {
            System.out.printf("Заклинание \"%s\" по id \"%d\" %s\n", entry.getValue().getEventType(),
                    entry.getValue().getId(), entry.getValue().getAction());
        }
    }


    public static void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);

        List<SpellEvent> spellEventList = new ArrayList<>();
        spellEventList.add(spellEvent);

        for (SpellEvent event : spellEventList) {
            if (!spellsByType.containsKey(eventType)) {
                spellsByType.put(eventType, new ArrayList<>());
            }
            spellsByType.get(eventType).add(event);

        }

        id++;
    }

}
