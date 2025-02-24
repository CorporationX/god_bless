package school.faang.task_44644;

import static school.faang.task_44644.EventType.EXPECTO_PATRONUM;
import static school.faang.task_44644.EventType.LUMOS;
import static school.faang.task_44644.EventType.PROTECTION;
import static school.faang.task_44644.EventType.TRANSFIGURATION;

public class Main {

    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent(new SpellEvent(4, LUMOS));
        hogwartsSpells.addSpellEvent(new SpellEvent(6, TRANSFIGURATION));
        hogwartsSpells.addSpellEvent(new SpellEvent(8, PROTECTION));
        hogwartsSpells.addSpellEvent(new SpellEvent(9, EXPECTO_PATRONUM));
        hogwartsSpells.printAllSpellEvents();
        hogwartsSpells.getSpellEventById(9);
        hogwartsSpells.getSpellEventsByType(LUMOS);
        hogwartsSpells.deleteSpellEvent(6);
    }
}