package school.faang.task_57308;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("Defense", "Defense from enemy attack");
        hogwartsSpells.addSpellEvent("Defense", "Strong defense");
        hogwartsSpells.addSpellEvent("Attack", "Attack your enemy");
        hogwartsSpells.addSpellEvent("Shout", "Shout at your enemy");
        log.info(String.valueOf(hogwartsSpells.getSpellEventById(1)));
        log.info(String.valueOf(hogwartsSpells.getSpellEventsByType("Defense")));
        hogwartsSpells.printAllSpellEvents();
        hogwartsSpells.deleteSpellEvent(0);
        hogwartsSpells.deleteSpellEvent(1);
        hogwartsSpells.deleteSpellEvent(2);
        hogwartsSpells.deleteSpellEvent(3);
        hogwartsSpells.deleteSpellEvent(4);
        hogwartsSpells.printAllSpellEvents();
    }
}
