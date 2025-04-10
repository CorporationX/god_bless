package school.faang.bjs2_68712;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("Protection", "Protection against Darkness");
        hogwartsSpells.addSpellEvent("Attack", "Attack against Darkness");
        hogwartsSpells.printAllSpellEvents();
        hogwartsSpells.deleteSpellEvent(2);
        hogwartsSpells.addSpellEvent("Attack", "Attack against Magic");
        hogwartsSpells.printAllSpellEvents();
        SpellEvent spellEvent = hogwartsSpells.getSpellEventById(1);
        if (spellEvent != null) {
            log.info(spellEvent.getEventType());
        }
        List<SpellEvent> attackSpells = hogwartsSpells.getSpellEventsByType("Attack");
        if (attackSpells != null) {
            for (SpellEvent event: attackSpells){
                log.info(event.getEventType());
            }
        }
    }
}