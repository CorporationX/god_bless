package school.faang.bjs2_57222;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
public class HogwartsSpells {

    private static int counterId = 0;

    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        int id = counterId++;
        SpellEvent event = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, event);
        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(event);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.getOrDefault(id, null);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, null);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            List<SpellEvent> spellEventList = getSpellEventsByType(spellEvent.getEventType());
            if (spellEventList != null) {
                spellEventList.remove(spellEvent);
            }
        }
    }

    public void printAllSpellEvents() {
        for (SpellEvent spellEvent : spellById.values()) {
            System.out.println(spellEvent);
        }
    }

}
