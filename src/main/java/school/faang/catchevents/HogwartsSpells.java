package school.faang.catchevents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class HogwartsSpells {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger();
    private static final Map<Integer, SpellEvent> SPELL_BY_ID = new HashMap<>();
    private static final Map<String, List<SpellEvent>> SPELL_BY_TYPE = new HashMap<>();

    private static void addSpellEvent(String eventType, String actionDescription) {
        int id = ID_GENERATOR.incrementAndGet();
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);

        SPELL_BY_ID.put(id, spellEvent);
        SPELL_BY_TYPE.computeIfAbsent(eventType, event -> new ArrayList<>()).add(spellEvent);
    }

    private static SpellEvent getSpellEventById(int id) {
        SpellEvent spellEvent = SPELL_BY_ID.get(id);

        if (spellEvent == null) {
            System.out.println("SpellEvent with id = " + id + " was not found");
        }
        return spellEvent;
    }

}
