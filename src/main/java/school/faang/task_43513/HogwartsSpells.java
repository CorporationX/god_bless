package school.faang.task_43513;

import lombok.Data;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Data
public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = Collections.emptyMap();
    private final Map<EventType, List<SpellEvent>> spellByType = Collections.emptyMap();

    public void addSpellEvent(int id, EventType eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);

        spellById.put(id, spellEvent);
        spellByType.putIfAbsent(eventType, Collections.emptyList());
        spellByType.get(eventType).add(spellEvent);
    }

    public SpellEvent getSpellById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellByType(EventType eventType) {
        return spellByType.getOrDefault(eventType, Collections.emptyList());
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            spellByType.get(spellEvent.getEventType()).remove(spellEvent);
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
