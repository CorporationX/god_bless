package school.faang.task_444454;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public class HogwartsSpell {
    private final Map<Integer, SpellEvent> spellById;
    private final Map<String, List<SpellEvent>> spellsByType;

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent newSpellEvent = new SpellEvent(id, eventType, actionDescription);
        List<SpellEvent> spellEvents = spellsByType.get(eventType);
        spellEvents.add(newSpellEvent);
        spellById.putIfAbsent(id, newSpellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        String eventType = spellById.get(id).getEventType();
        spellById.remove(id);

        List<SpellEvent> spellEvents = spellsByType.get(eventType);
        spellEvents.removeIf(e -> e.getId() == id);
    }

    public void printAllSpellEvents() {
        for (var entry : spellById.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
