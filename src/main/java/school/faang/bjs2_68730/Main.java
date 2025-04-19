package school.faang.bjs2_68730;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent(EventType.PROTECTION, "левиосААА");
        hogwartsSpells.addSpellEvent(EventType.PROTECTION, "Алохамора");

        hogwartsSpells.printAllSpellEvents();
        hogwartsSpells.printAllSpellsByType();

        var spellEvent = hogwartsSpells.getSpellEventById(1);
        log.info(String.valueOf(spellEvent));

        var spellEvents = hogwartsSpells.getSpellEventsByType(EventType.PROTECTION);
        log.info(String.valueOf(spellEvents));

        hogwartsSpells.deleteSpellEvent(1);
        hogwartsSpells.printAllSpellEvents();
        hogwartsSpells.printAllSpellsByType();
    }
}
