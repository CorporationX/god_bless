package school.faang.bjs2_85792;

import ch.qos.logback.core.pattern.util.AlmostAsIsEscapeUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HogwartsSpells {
    private static final int DEFAULT_ID = 0;
    private HashMap<Integer, SpellEvent> spellById = new HashMap<>();
    private HashMap<String, List<SpellEvent>> spellByType = new HashMap<>();
    private int id = DEFAULT_ID;

    public void addSpellEvent(String eventType, String actionDescription) {

        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        id++;

        spellByType.computeIfAbsent(eventType, arr -> new ArrayList<>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {

        System.out.println(spellById.get(id));

        String eventType = spellById.get(id).getEventType();
        List<SpellEvent> listEventType = spellByType.get(eventType);
        SpellEvent spellEvent = listEventType.stream()
                .filter(sp -> sp.getId() == id)
                .findFirst().orElse(null);
        if (spellEvent != null) {
            listEventType.remove(spellEvent);
        }
        spellByType.put(eventType, listEventType);

        spellById.remove(id);
    }

    public void printAllSpellEvents() {
        System.out.println("list events");
        System.out.println(spellById);
        System.out.println("List by spell type");
        System.out.println(spellByType);
    }
}
