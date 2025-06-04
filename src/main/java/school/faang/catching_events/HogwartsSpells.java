package school.faang.catching_events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(eventType, actionDescription);
        spellById.put(spellEvent.getId(), spellEvent);
        if (spellByType.containsKey(eventType)) {
            spellByType.get(eventType).add(spellEvent);
        } else {
            spellByType.putIfAbsent(eventType, new ArrayList<>() {{
                add(spellEvent);
            }});
        }
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) throws IllegalArgumentException {
        if (spellByType.containsKey(eventType)) {
            return spellByType.get(eventType);
        } else {
            throw new IllegalArgumentException("Not event type");
        }
    }

    public void deleteSpellEvent(int id) {
        if (spellById.containsKey(id)) {
            spellById.remove(id);
        } else {
            throw new IllegalArgumentException("Not id");
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> spell : spellById.entrySet()) {
            System.out.println(spell.getValue());
        }
        System.out.println("\n********************************************\n");
    }
}
