package school.faang.catcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private final static Map<Integer, SpellEvent> SPELL_BY_ID = new HashMap<>();
    private final static Map<String, List<SpellEvent>> SPELLS_BY_TYPE = new HashMap<>();
    private static int countId = 0;

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(countId, eventType, actionDescription);
        SPELL_BY_ID.put(countId, spellEvent);
        SPELLS_BY_TYPE.computeIfAbsent(eventType, u -> new ArrayList<>()).add(spellEvent);
        countId++;
    }


}
