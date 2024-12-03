package school.faang.task_43513;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<EventType, List<SpellEvent>> spellByType = new HashMap<>();

    public void addSpellEvent(int id, EventType eventType, String actionDescription) {
        SpellEvent spellEvent = SpellEvent.builder()
                .id(id)
                .eventType(eventType)
                .action(actionDescription)
                .build();

         spellById.put(id, spellEvent);

         if (!spellByType.containsKey(eventType)) {
             spellByType.put(eventType, new ArrayList<>());
         }

         spellByType.get(eventType).add(spellEvent);
    }

    public SpellEvent getSpellById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellByType(EventType eventType) {
        return spellByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        spellByType.get(spellEvent.getEventType()).remove(spellEvent);
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
