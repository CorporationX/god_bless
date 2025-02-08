package school.faang.BJS2_57150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private static final Map<Integer, SpellEvent> SPELL_BY_ID = new HashMap<>();
    private static final Map<String, List<SpellEvent>> SPELLS_BY_TYPE = new HashMap<>();
    private int currentSpellId = 1;

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(currentSpellId, eventType, actionDescription);
        SPELL_BY_ID.put(currentSpellId, spellEvent);
        SPELLS_BY_TYPE.putIfAbsent(eventType, new ArrayList<>());
        SPELLS_BY_TYPE.get(eventType).add(spellEvent);
        currentSpellId++;
    }

    public SpellEvent getSpellEventById(int id) {
        if (id < currentSpellId) {
            return SPELL_BY_ID.get(id);
        } else {
            return null;
        }
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        if (SPELLS_BY_TYPE.containsKey(eventType)) {
            return SPELLS_BY_TYPE.get(eventType);
        } else {
            return null;
        }
    }

    public void deleteSpellEvent(int id) {
        if (id < currentSpellId) {
            SpellEvent spellEvent = SPELL_BY_ID.get(id);
            SPELL_BY_ID.remove(id);
            SPELLS_BY_TYPE.get(spellEvent.getEventType()).remove(spellEvent);
        }
    }

    public void printAllSpellEvents() {
        System.out.println("Список заклинаний:");
        for (Map.Entry<Integer, SpellEvent> entry : SPELL_BY_ID.entrySet()) {
            SpellEvent spellEvent = entry.getValue();
            System.out.println(spellEvent.getId() + ": " + spellEvent.getEventType() + " - "
                    + spellEvent.getAction());
        }
    }
}
