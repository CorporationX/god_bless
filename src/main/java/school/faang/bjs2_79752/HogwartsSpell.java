package school.faang.bjs2_79752;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class HogwartsSpell {
    private Map<Integer, SpellEvent> spellsById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        int spellId = (eventType + actionDescription).hashCode();
        SpellEvent spellEvent = new SpellEvent(spellId, eventType, actionDescription);

        getSpellsById().put(spellId, spellEvent);
        getSpellsByType().computeIfAbsent(eventType, k -> new ArrayList<>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        if (getSpellsById().get(id) == null) {
            throw new IllegalArgumentException("Illegal id");
        }
        return getSpellsById().get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        if (getSpellsByType().get(eventType) == null) {
            throw new IllegalArgumentException("Illegal type");
        }
        return new ArrayList<>(spellsByType.getOrDefault(eventType, Collections.emptyList()));
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEventForDelete = getSpellsById().get(id);
        if (spellEventForDelete != null) {
            List<SpellEvent> spellEventList = getSpellsByType().get(spellEventForDelete.getEventType());
            if (spellEventList != null) {
                spellEventList.remove(spellEventForDelete);
            }
            getSpellsById().remove(id);
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> spellEntry : getSpellsById().entrySet()) {
            SpellEvent spell = spellEntry.getValue();
            System.out.printf("id: %s, type: %s, action: %s%n",
                    spell.getId(), spell.getEventType(), spell.getActionDescription());
        }
    }
}