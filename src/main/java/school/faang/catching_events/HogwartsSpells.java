package school.faang.catching_events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> SPELL_BY_ID = new HashMap<>();
    private final Map<String, List<SpellEvent>> SPELL_BY_TYPE = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(eventType, actionDescription);
        SPELL_BY_ID.put(spellEvent.getId(), spellEvent);
        if (SPELL_BY_TYPE.containsKey(eventType)) {
            SPELL_BY_TYPE.get(eventType).add(spellEvent);
        } else {
            SPELL_BY_TYPE.putIfAbsent(eventType, new ArrayList<>() {{
                add(spellEvent);
            }});
        }
    }

    public SpellEvent getSpellEventById(int id) {
        return SPELL_BY_ID.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) throws IllegalArgumentException {
        if (SPELL_BY_TYPE.containsKey(eventType)) {
            return SPELL_BY_TYPE.get(eventType);
        } else {
            throw new IllegalArgumentException("Not event type");
        }
    }

    public void deleteSpellEvent(int id) {
        if (SPELL_BY_ID.containsKey(id)) {
            SPELL_BY_ID.remove(id);
        } else {
            throw new IllegalArgumentException("Not id");
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> spell : SPELL_BY_ID.entrySet()) {
            System.out.println(spell.getValue());
        }
        System.out.println("\n********************************************\n");
    }
}
