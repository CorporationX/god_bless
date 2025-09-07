package school.faang.bjs2_85753;

import java.util.*;

public class HogwartsSpells {
    private static final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private static final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private static int idForEachSpellEvent = 1;

    private HogwartsSpells() {

    }

    static void addSpellEvent(String eventType, String action) {
        if (eventType == null || action == null) {
            throw new NullPointerException("Заклинание должно иметь тип и действие");
        }
        SpellEvent spell = new SpellEvent(idForEachSpellEvent, eventType, action);

        if (spellById.containsValue(spell)) {
            throw new SpellAlreadyExistsException("Такое заклинание уже есть!");
        } else {
            spellById.put(idForEachSpellEvent++, spell);
        }
        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(spell);
    }

    static SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    static List<SpellEvent> getSpellEventsByType(String eventType) {
        if (spellsByType.containsKey(eventType)) {
            return spellsByType.get(eventType);
        } else {
            throw new IllegalArgumentException("Такого типа заклинаний не существует!");
        }
    }

    static void deleteSpellEvent(int id) {
        SpellEvent spell = spellById.remove(id);
        spellsByType.get(spell.getEventType()).remove(spell);
    }

    static void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> pair : spellById.entrySet()) {
            System.out.println(pair.getValue());
        }
    }
}