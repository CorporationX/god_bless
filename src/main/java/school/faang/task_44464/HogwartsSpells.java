package school.faang.task_44464;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById;
    private Map<EventType, List<SpellEvent>> spellByType;

    public HogwartsSpells() {
        spellById = new HashMap<>();
        spellByType = new HashMap<>();
    }

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        EventType eventTypeEnum = EventType.valueOf(eventType);
        SpellEvent spellEvent = new SpellEvent(id, eventTypeEnum, actionDescription);
        spellById.put(id, spellEvent);
        spellByType.computeIfAbsent(eventTypeEnum, e -> new ArrayList<>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventByType(String eventType) {
        EventType eventTypeEnum = EventType.valueOf(eventType);
        return spellByType.getOrDefault(eventTypeEnum, new ArrayList<>());
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            List<SpellEvent> spellEvents = spellByType.get(spellEvent.getEventType());
            if (spellEvents != null) {
                spellEvents.remove(spellEvent);
                if (spellEvents.isEmpty()) {
                    spellByType.remove(spellEvent.getEventType());
                }
            }
        }
    }

    public void printAllEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
