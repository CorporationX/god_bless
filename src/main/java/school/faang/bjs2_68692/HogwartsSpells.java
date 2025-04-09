package school.faang.bjs2_68692;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private int idSpell;

    public void addSpellEvent(String eventType, String actionDescription) {
        idSpell++;
        SpellEvent spellEvent =
                SpellEvent.builder()
                        .id(idSpell)
                        .eventType(eventType)
                        .action(actionDescription).build();
        spellById.put(idSpell, spellEvent);
        spellsByType.computeIfAbsent(eventType, e -> new ArrayList<>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        if (spellById.containsKey(id)) {
            spellsByType.remove(spellById.get(id).getEventType());
        }
        spellById.remove(id);
    }

    public void printAllSpellEvents() {
        for (SpellEvent spellEvent : spellById.values()) {
            System.out.println(spellEvent);
        }
    }
}
