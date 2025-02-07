package school.faang.bjs2_57010;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    Map<Integer, SpellEvent> spellById = new HashMap<>();
    Map<String, List<SpellEvent>> spellByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription
    ) {
        SpellEvent spellEvent = new SpellEvent(eventType, actionDescription);
        spellById.put(spellEvent.getId(), spellEvent);
        spellByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(spellEvent);
    }

    public void getSpellEventById(int id) {
        SpellEvent spell = spellById.get(id);
        if (spell != null) {
            System.out.printf("Spell by %s%n", spell);
        } else {
            System.out.println("Spell not found for ID: " + id);
        }
    }

    public void getSpellByType(String eventType) {
        if (spellByType.get(eventType) != null) {
            System.out.println(spellByType.get(eventType));
        } else {
            System.out.println("Spell not found for eventType: " + eventType);
        }
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.get(id);
        if (spellEvent != null) {
            spellById.remove(id);
            spellByType.remove(spellEvent.getEventType());
        } else {
            System.out.println("Spell not found for ID: " + id);
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
