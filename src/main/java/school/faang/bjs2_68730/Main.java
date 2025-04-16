package school.faang.bjs2_68730;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        HogwartsSpells.addSpellEvent(EventType.PROTECTION, "левиосААА");
        HogwartsSpells.addSpellEvent(EventType.PROTECTION, "Алохамора");

        HogwartsSpells.printAllSpellEvents();
        HogwartsSpells.printAllSpellsByType();

        var spellEvent = HogwartsSpells.getSpellEventById(1);
        log.info(String.valueOf(spellEvent));

        var spellEvents = HogwartsSpells.getSpellEventsByType(EventType.PROTECTION);
        log.info(String.valueOf(spellEvents));

        HogwartsSpells.deleteSpellEvent(1);
        HogwartsSpells.printAllSpellEvents();
        HogwartsSpells.printAllSpellsByType();
    }
}
