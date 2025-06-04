package school.faang.module1.bjs2_79704;

import java.util.*;

public class HogwartsSpells {

    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private static final int ID_MIN = 1;
    private static final int ID_MAX = 7;
    private final Random random = new Random();

    public void addSpellEvent(String eventType, String actionDescription) {
        int id = generateUniqueId();
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        spellsByType.computeIfAbsent(eventType, e -> new ArrayList<>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public SpellEvent deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent == null) {
            return null;
        }
        List<SpellEvent> events = spellsByType.get(spellEvent.getEventType());
        if (events == null || !events.remove(spellEvent)) {
            return null;
        }
        return spellEvent;
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            SpellEvent spellEvent = entry.getValue();
            System.out.println(spellEvent);
        }
    }

    private int generateUniqueId() {
        int id;
        do {
            id = random.nextInt(ID_MAX - ID_MIN + 1) + ID_MIN;
        } while (spellById.containsKey(id));
        return id;
    }
}