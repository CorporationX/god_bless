package school.faang.catchevents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class HogwartsSpells {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger();
    private static final Map<Integer, SpellEvent> SPELL_BY_ID = new HashMap<>();
    private static final Map<String, List<SpellEvent>> SPELL_BY_TYPE = new HashMap<>();

    public static void main(String[] args) {
        addSpellEvent("Сектумсемпра", "Нанесение глубоких резаных ран");
        addSpellEvent("Конфринго", "Заклинание пожара и взрыва");
        addSpellEvent("Протего", "Щитовые чары");
        addSpellEvent("Импедимента", "Чары помех");

        System.out.println(getSpellEventById(1));
        System.out.println(getSpellEventById(3));

        System.out.println(getSpellEventsByType("Сектумсемпра"));
        System.out.println(getSpellEventsByType("Импедимента"));

        deleteSpellEvent(1);
        deleteSpellEvent(2);

        printAllSpellEvents();
    }

    private static SpellEvent addSpellEvent(String eventType, String actionDescription) {
        if (eventType == null || eventType.trim().isEmpty()) {
            throw new IllegalArgumentException("EventType is required");
        }
        if (actionDescription == null || actionDescription.trim().isEmpty()) {
            throw new IllegalArgumentException("ActionDescription is required");
        }

        int id = ID_GENERATOR.incrementAndGet();
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);

        SPELL_BY_ID.put(id, spellEvent);
        SPELL_BY_TYPE.computeIfAbsent(eventType, event -> new ArrayList<>()).add(spellEvent);

        return spellEvent;
    }

    private static SpellEvent getSpellEventById(int id) {
        SpellEvent spellEvent = SPELL_BY_ID.get(id);

        if (spellEvent == null) {
            System.out.println("SpellEvent with id = " + id + " was not found");
        }
        return spellEvent;
    }

    private static List<SpellEvent> getSpellEventsByType(String eventType) {
        List<SpellEvent> spellEvents = SPELL_BY_TYPE.get(eventType);

        if (spellEvents == null) {
            System.out.println("SpellEvents with type = " + eventType + " + was not found");
        }
        return spellEvents;
    }

    private static boolean deleteSpellEvent(int id) {
        SpellEvent spellEvent = SPELL_BY_ID.get(id);

        if (spellEvent != null) {
            String eventType = spellEvent.getEventType();
            List<SpellEvent> spellEvents = SPELL_BY_TYPE.get(eventType);

            spellEvents.remove(spellEvent);
            SPELL_BY_ID.remove(id);
            return true;
        }

        return false;
    }

    private static void printAllSpellEvents() {
        for (var entry : SPELL_BY_ID.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

}
