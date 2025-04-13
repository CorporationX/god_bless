package school.faang.bjs2_68810.catch_event;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    private static final String FOUNDED_SPELL_EVENT = "Founded spell event: {}";
    private static final String FOUNDED_SPELL_EVENTS_LIST = "Founded spell events list: {}";
    private static final String REMOVING_SPELL_EVENT_IS_OK = "Removing spell event with index {} is ok";

    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent("Protection", "Protects from attack");
        hogwartsSpells.addSpellEvent("Protection", "Protects from trolls");
        hogwartsSpells.addSpellEvent("Protection", "Protects from boggarts");
        hogwartsSpells.addSpellEvent("Protection", "Protects from dementors");
        hogwartsSpells.addSpellEvent("Transformation", "Transforms animals to cup");
        hogwartsSpells.addSpellEvent("Charm", "Erases memory");
        hogwartsSpells.addSpellEvent("Charm", "Turns on the lights");

        hogwartsSpells.printAllSpellEvents();

        // Testing getSpellEventById
        // ok
        try {
            SpellEvent spellEvent = hogwartsSpells.getSpellEventById(5);
            log.info(FOUNDED_SPELL_EVENT, spellEvent);
        } catch (SpellEventNotFoundException e) {
            log.error(e.getMessage());
        }
        // exception
        try {
            SpellEvent spellEvent = hogwartsSpells.getSpellEventById(50);
            log.info(FOUNDED_SPELL_EVENT, spellEvent);
        } catch (SpellEventNotFoundException e) {
            log.error(e.getMessage());
        }

        // Testing getSpellEventsByType
        // ok
        try {
            List<SpellEvent> spellEventList = hogwartsSpells.getSpellEventsByType("Protection");
            log.info(FOUNDED_SPELL_EVENTS_LIST, spellEventList);
        } catch (SpellEventNotFoundException e) {
            log.error(e.getMessage());
        }
        // exception
        try {
            List<SpellEvent> spellEventList = hogwartsSpells.getSpellEventsByType("Magic");
            log.info(FOUNDED_SPELL_EVENTS_LIST, spellEventList);
        } catch (SpellEventNotFoundException e) {
            log.error(e.getMessage());
        }

        // Testing deleteSpellEvent
        // ok
        try {
            hogwartsSpells.deleteSpellEvent(3);
            log.info(REMOVING_SPELL_EVENT_IS_OK, 3);
        } catch (SpellEventNotFoundException e) {
            log.error(e.getMessage());
        }
        // exception
        try {
            hogwartsSpells.deleteSpellEvent(30);
            log.info(REMOVING_SPELL_EVENT_IS_OK, 30);
        } catch (SpellEventNotFoundException e) {
            log.error(e.getMessage());
        }

        hogwartsSpells.printAllSpellEvents();
    }
}
