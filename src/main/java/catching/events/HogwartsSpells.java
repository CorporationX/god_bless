package catching.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    protected void addSpellEvent(String eventType, String actionDescription) {
        Integer randomId = ThreadLocalRandom.current().nextInt(1, 10);

        this.spellById.put(randomId, new SpellEvent(randomId, eventType, actionDescription));
        this.spellsByType.putIfAbsent(eventType, new ArrayList<>());
        this.spellsByType.get(eventType).add(new SpellEvent(randomId, eventType, actionDescription));
    }

    protected SpellEvent getSpellEventById(int id) {
        if (this.spellById.containsKey(id)) {
            return this.spellById.get(id);
        } else {
            System.out.printf("Spell event with this %d is not found!", id);
        }
        return null;
    }

    protected List<SpellEvent> getSpellEventsByType(String eventType) {
        if (this.spellsByType.containsKey(eventType)) {
            return this.spellsByType.get(eventType);
        } else {
            System.out.printf("Event type %s is not found!", eventType);
        }
        return null;
    }

    protected void deleteSpellEvent(int id) {
        if (this.spellById.containsKey(id)) {
            SpellEvent spellEventObject = this.spellById.get(id);
            String eventType = spellEventObject.getEventType();

            this.spellById.remove(id);
            this.spellsByType.get(eventType).remove(spellEventObject);
        } else {
            System.out.printf("Spell event with this %d is not found!", id);
        }
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
