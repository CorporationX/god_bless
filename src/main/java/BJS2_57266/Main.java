package BJS2_57266;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("spell", "Accio");
        hogwartsSpells.addSpellEvent("spell", "Expelliarmus");
        hogwartsSpells.addSpellEvent("spell", "Expecto Patronum");

        hogwartsSpells.printAllSpellEvents();
        log.info("------------------------------------");
        log.info(hogwartsSpells.getSpellEventById(2).toString());
        log.info("------------------------------------");
        hogwartsSpells.deleteSpellEvent(2);
        hogwartsSpells.printAllSpellEvents();
        log.info("------------------------------------");
        log.info(hogwartsSpells.getSpellEventsByType("spell").toString());
        log.info("------------------------------------");
        hogwartsSpells.addSpellEvent("spell", "Stupefy");
        hogwartsSpells.printAllSpellEvents();
    }
}
