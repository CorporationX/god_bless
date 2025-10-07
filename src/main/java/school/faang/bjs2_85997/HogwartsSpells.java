package school.faang.bjs2_85997;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
public class HogwartsSpells {
    private final HashMap<String, SpellEvent> spellById = new HashMap<>();
    private final HashMap<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        String id = UUID.randomUUID().toString();
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);

        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);
    }

    public SpellEvent getSpellEventById(String id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public void deleteSpellEvent(String id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            List<SpellEvent> events = spellsByType.get(spellEvent.getEventType());
            if (events != null) {
                events.remove(spellEvent);
            }
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<String, SpellEvent> spellEntry : spellById.entrySet()) {
            System.out.println(spellEntry.getValue());
        }
    }
}
