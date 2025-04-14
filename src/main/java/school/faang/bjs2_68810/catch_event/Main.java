package school.faang.bjs2_68810.catch_event;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.UUID;

@Slf4j
public class Main {
    private static final String FOUNDED_SPELL_EVENT = "Founded spell event: {}";
    private static final String FOUNDED_SPELL_EVENTS_LIST = "Founded spell events list: {}";
    private static final String REMOVING_SPELL_EVENT_IS_OK = "Removing spell event with index {} is ok";

    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        UUID realIdOfSpellEvent = new UUID(0L, 0L);

        hogwartsSpells.addSpellEvent(EventType.PROTECTION, "Protects from attack");
        hogwartsSpells.addSpellEvent(EventType.PROTECTION, "Protects from trolls");
        hogwartsSpells.addSpellEvent(EventType.PROTECTION, "Protects from boggarts");
        hogwartsSpells.addSpellEvent(EventType.PROTECTION, "Protects from dementors");
        hogwartsSpells.addSpellEvent(EventType.TRANSFORMATION, "Transforms animals to cup");
        hogwartsSpells.addSpellEvent(EventType.CHARM, "Erases memory");
        hogwartsSpells.addSpellEvent(EventType.CHARM, "Turns on the lights");

        hogwartsSpells.printAllSpellEvents();

        try {
            List<SpellEvent> spellEventList = hogwartsSpells.getSpellEventsByType(EventType.PROTECTION);
            log.info(FOUNDED_SPELL_EVENTS_LIST, spellEventList);
            realIdOfSpellEvent = spellEventList.get(0).getId();
        } catch (SpellEventNotFoundException e) {
            log.error(e.getMessage());
        }
        try {
            List<SpellEvent> spellEventList = hogwartsSpells.getSpellEventsByType(EventType.MAGIC);
            log.info(FOUNDED_SPELL_EVENTS_LIST, spellEventList);
        } catch (SpellEventNotFoundException e) {
            log.error(e.getMessage());
        }

        try {
            SpellEvent spellEvent = hogwartsSpells.getSpellEventById(realIdOfSpellEvent);
            log.info(FOUNDED_SPELL_EVENT, spellEvent);
        } catch (SpellEventNotFoundException e) {
            log.error(e.getMessage());
        }
        try {
            SpellEvent spellEvent = hogwartsSpells.getSpellEventById(UUID.randomUUID());
            log.info(FOUNDED_SPELL_EVENT, spellEvent);
        } catch (SpellEventNotFoundException e) {
            log.error(e.getMessage());
        }

        try {
            hogwartsSpells.deleteSpellEvent(realIdOfSpellEvent);
            log.info(REMOVING_SPELL_EVENT_IS_OK, realIdOfSpellEvent);
        } catch (SpellEventNotFoundException e) {
            log.error(e.getMessage());
        }
        try {
            UUID randomValue = UUID.randomUUID();
            hogwartsSpells.deleteSpellEvent(randomValue);
            log.info(REMOVING_SPELL_EVENT_IS_OK, randomValue);
        } catch (SpellEventNotFoundException e) {
            log.error(e.getMessage());
        }

        hogwartsSpells.printAllSpellEvents();
    }
}
