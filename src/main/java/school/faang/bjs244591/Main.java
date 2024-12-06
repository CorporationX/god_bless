package school.faang.bjs244591;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent(1, SpellType.EXPECTO_PATRONUM, "Action1");
        hogwartsSpells.addSpellEvent(2, SpellType.EXPECTO_PATRONUM, "Action2");
        hogwartsSpells.addSpellEvent(3, SpellType.WINGARDIUM_LEVIOSA, "Action3");
        hogwartsSpells.addSpellEvent(4, SpellType.LUMOS, "Action4");
        hogwartsSpells.addSpellEvent(5, SpellType.LUMOS, "Action5");
        hogwartsSpells.addSpellEvent(6, SpellType.LUMOS, "Action6");

        hogwartsSpells.getSpellEventById(1);
        hogwartsSpells.deleteSpellEvent(2);

        List<SpellEvent> spellEventsByType = hogwartsSpells.getSpellEventsByType(SpellType.LUMOS);
        for (SpellEvent event : spellEventsByType) {
            System.out.println(event.getId() + " - " + event.getEventType() + " : " + event.getAction());
        }
        hogwartsSpells.printAllSpellEvents();
    }
}
