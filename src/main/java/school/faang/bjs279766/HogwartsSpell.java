package school.faang.bjs279766;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class HogwartsSpell {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        var spellEvent = new SpellEvent(eventType, actionDescription);
        this.spellById.put(spellEvent.getId(), spellEvent);
        var spellEvents = this.spellsByType.get(spellEvent.getEventType());
        if (spellEvents != null) {
            spellEvents.add(spellEvent);
        } else {
            var events = new ArrayList<SpellEvent>();
            events.add(spellEvent);
            this.spellsByType.put(spellEvent.getEventType(), events);
        }
    }

    public SpellEvent getSpellEventById(int id) {
        return this.spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return this.spellsByType.get(eventType);
    }

    public SpellEvent deleteSpellEvent(int id) {
        var deletedSpellEvent = this.spellById.remove(id);
        if (deletedSpellEvent != null) {
            var spellEvents = this.spellsByType.get(deletedSpellEvent.getEventType());
            if (spellEvents != null) {
                spellEvents.remove(deletedSpellEvent);
            }
        }
        return deletedSpellEvent;
    }

    public void printAllSpellEvents() {
        this.spellById.forEach((id, spellEvent) -> System.out.println(spellEvent));
    }

    public void printSpellEventsByType(String eventType) {
        var spellEvents = this.getSpellEventsByType(eventType);
        if (spellEvents != null) {
            spellEvents.forEach(System.out::println);
        }
    }
}
