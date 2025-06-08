package school.faang.bjs2_79752;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class HogwartsSpell {
    private Map<Integer, SpellEvent> spellsById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        int spellId = new SpellId(eventType, actionDescription).hashCode();

        getSpellsById().put(spellId, new SpellEvent(spellId, eventType, actionDescription));

        List<SpellEvent> eventList;
        if (getSpellsByType().get(eventType) == null) {
            eventList = new LinkedList<>();
            eventList.add(new SpellEvent(spellId, eventType, actionDescription));
        } else {
            eventList = getSpellsByType().get(eventType);
            eventList.add(new SpellEvent(spellId, eventType, actionDescription));
        }
        getSpellsByType().put(eventType, eventList);
    }

    public SpellEvent getSpellEventById(int id) {
        if (getSpellsById().get(id) == null) {
            System.out.println("Spell is not found");
        }
        return getSpellsById().get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        if (getSpellsByType().get(eventType) == null) {
            System.out.println("Spell is not found");
        }
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEventForDelete = getSpellsById().get(id);
        List<SpellEvent> spellEventList = getSpellsByType().get(spellEventForDelete.getEventType());
        spellEventList.remove(spellEventForDelete);

        getSpellsById().remove(id);
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> spellEntry : getSpellsById().entrySet()) {
            SpellEvent spell = spellEntry.getValue();
            System.out.printf("id: %s, type: %s, action: %s%n",
                    spell.getId(), spell.getEventType(), spell.getActionDescription());
        }
    }
}