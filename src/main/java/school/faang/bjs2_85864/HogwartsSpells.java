package school.faang.bjs2_85864;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public SpellEvent addSpellEvent(String eventType, String actionDescription) {
        SpellEvent event = new SpellEvent(eventType, actionDescription);
        spellById.put(event.getId(), event);
        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(event);
        return event;
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, Collections.emptyList());
    }

    public boolean deleteSpellEvent(int id) {
        SpellEvent event = spellById.remove(id);
        if (event != null) {
            List<SpellEvent> listByType = spellsByType.get(event.getEventType());
            if (listByType != null) {
                listByType.remove(event);
                if (listByType.isEmpty()) {
                    spellsByType.remove(event.getEventType());
                }
            }
            return true;
        }
        return false;
    }

    public List<SpellEvent> printAllSpellEvents() {
        return new ArrayList<>(spellById.values());
    }
}