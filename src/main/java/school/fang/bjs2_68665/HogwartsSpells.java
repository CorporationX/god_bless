package school.fang.bjs2_68665;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.NoSuchElementException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HogwartsSpells {

    private Map<Integer, SpellEvent> spellById;
    private Map<String, SpellEvent> spellsByType;


    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        spellsByType.put(eventType, spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        if (spellById.containsKey(id)) {
            return spellById.get(id);
        }
        throw new NoSuchElementException("No such spell event");
    }

    public SpellEvent getSpellByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = getSpellEventById(id);
        boolean removed = spellsByType.entrySet().removeIf(entry -> entry.getValue().equals(spellEvent));
        if (!removed) {
            throw new NoSuchElementException("No such spell event");
        }
        spellById.remove(id);
    }

    public void printAllSpellEvents() {
        spellById.forEach((id, value) ->
                System.out.printf(
                        "Spell with id %d is %s with action %s\n", id, value.getEventType(), value.getAction())
        );
    }
}



