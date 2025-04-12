package school.faang.catch_events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {

    private Map<Integer, SpellEvent> spellById;
    private Map<String, List<SpellEvent>> spellsByType;

    private int eventId;

    public HogwartsSpells() {
        spellById = new HashMap<>();
        spellsByType = new HashMap<>();
        eventId = 0;
    }

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent event = new SpellEvent(++eventId, eventType, actionDescription);
        spellById.put(eventId, event);
        spellsByType.computeIfAbsent(eventType, a -> new ArrayList<>()).add(event);
    }

}
