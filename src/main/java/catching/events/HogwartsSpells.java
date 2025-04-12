package catching.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private Integer randomId = 0;

    protected void addSpellEvent(String eventType, String actionDescription) {
        randomId++;
        this.spellById.put(randomId, new SpellEvent(randomId, eventType, actionDescription));
        this.spellsByType.computeIfAbsent(eventType, key -> new ArrayList<>())
                .add(new SpellEvent(randomId, eventType, actionDescription));
    }

    protected SpellEvent getSpellEventById(int id) {
        if (!this.spellById.containsKey(id)) {
            throw new IllegalArgumentException("Spell event with id " + id + " is not found!");
        }
        return this.spellById.get(id);
    }

    protected List<SpellEvent> getSpellEventsByType(String eventType) {
        if (!this.spellsByType.containsKey(eventType)) {
            throw new IllegalArgumentException("Event type " + eventType + " is not found!");
        }
        return this.spellsByType.get(eventType);
    }

    protected void deleteSpellEvent(int id) {
        if (!this.spellById.containsKey(id)) {
            throw new IllegalArgumentException("Spell event with id " + id + " is not found!");
        }
        SpellEvent spellEventObject = this.spellById.get(id);
        String eventType = spellEventObject.getEventType();
        this.spellById.remove(id);
        this.spellsByType.get(eventType).remove(spellEventObject);
    }

    protected void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entries : this.spellById.entrySet()) {
            SpellEvent value = entries.getValue();
            System.out.printf("Spell event id is %d , event type is %s and action is %s %n",
                    entries.getKey(),
                    value.getEventType(),
                    value.getAction());
        }
    }
}
