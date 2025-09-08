package school.faang.bjs2_85831.spell;

import school.faang.bjs2_85831.exception.EventTypeNotAllowedException;
import school.faang.bjs2_85831.exception.SpellEventNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class HogwartsSpells {
    private static final Map<Integer, SpellEvent> SPELLS_BY_ID = new HashMap<>();
    private static final Map<String, List<SpellEvent>> SPELLS_BY_TYPE = new HashMap<>();

    private HogwartsSpells() {

    }

    public static void addSpellEvent(String eventType, String action) {
        SpellEventValidator.validateSpellEvent(eventType, action);
        SpellEvent newSpell = new SpellEvent(eventType, action);
        SPELLS_BY_ID.put(newSpell.getId(), newSpell);
        SPELLS_BY_TYPE.computeIfAbsent(eventType, k -> new ArrayList<>()).add(newSpell);
    }

    public static void deleteSpellEvent(int id) {
        ensureSpellExistsById(id);
        SpellEvent deletedSpell = SPELLS_BY_ID.remove(id);
        SPELLS_BY_TYPE.get(deletedSpell.getEventType()).remove(deletedSpell);
        if (SPELLS_BY_TYPE.get(deletedSpell.getEventType()).isEmpty()) {
            SPELLS_BY_TYPE.remove(deletedSpell.getEventType());
        }
    }

    public static void deleteSpellEvents(String eventType) {
        ensureSpellEventTypeExists(eventType);
        List<SpellEvent> deletedSpells = SPELLS_BY_TYPE.remove(eventType);
        for (SpellEvent spell : deletedSpells) {
            SPELLS_BY_ID.remove(spell.getId());
        }
    }

    public static SpellEvent getSpellEventById(int id) {
        ensureSpellExistsById(id);
        return SPELLS_BY_ID.get(id);
    }

    public static List<SpellEvent> getSpellEventsByType(String eventType) {
        ensureSpellEventTypeExists(eventType);
        return SPELLS_BY_TYPE.get(eventType);
    }

    private static void ensureSpellExistsById(int id) {
        if (!SPELLS_BY_ID.containsKey(id)) {
            throw new SpellEventNotFoundException("заклинание с таким идентификатором не зарегистрировано в Хогвартс");
        }
    }

    private static void ensureSpellEventTypeExists(String eventType) {
        SpellEventValidator.validateSpellEventType(eventType);
        if (!SPELLS_BY_TYPE.containsKey(eventType)) {
            throw new EventTypeNotAllowedException("в школе Хогвартс пока нет подобных заклинаний");
        }
    }

    public static void printAllSpellEvents() {
        SPELLS_BY_ID.values().forEach(System.out::println);
    }
}
