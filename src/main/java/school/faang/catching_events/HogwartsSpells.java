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
        spellById.putIfAbsent(spellEvent.getId(), spellEvent);
        spellByType.computeIfAbsent(eventType, key -> new ArrayList<>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        if (!spellById.containsKey(id)) {
            throw new IllegalArgumentException("Not id");
        }
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) throws IllegalArgumentException {
        if (!spellByType.containsKey(eventType)) {
            throw new IllegalArgumentException("Not event type");
        }
        return spellByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        if (!spellById.containsKey(id)) {
            throw new IllegalArgumentException("Not id");
        }
        spellByType.computeIfAbsent(getSpellEventById(id).getEventType(), key -> new ArrayList<>())
                .remove(getSpellEventById(id));
        spellById.remove(id);
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> spell : spellById.entrySet()) {
            System.out.println(spell.getValue());
        }
        System.out.println("\n********************************************\n");
    }
}
