package school.faang.catchingevents;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.printAllSpellEvents();

        hogwartsSpells.addSpellEvent(1, "fireball", "A ball full of fire");
        hogwartsSpells.addSpellEvent(2, "snowball", "A ball full of snow");
        hogwartsSpells.addSpellEvent(3, "astral step", "Step through another dimension");
        hogwartsSpells.addSpellEvent(4, "snowball", "A ball full of snow");
        hogwartsSpells.addSpellEvent(5, "snowball", "A ball full of snow");
        hogwartsSpells.printAllSpellEvents();

        System.out.println("getting the spell event by id - " + 3);
        System.out.println(hogwartsSpells.getSpellEventById(3));

        System.out.println("getting the spell events by type snowball");
        List<SpellEvent> snowballEvents = hogwartsSpells.getSpellEventsByType("snowball");
        for (SpellEvent spellEvent : snowballEvents) {
            System.out.println(spellEvent);
        }

        hogwartsSpells.deleteSpellEvent(2);
        hogwartsSpells.printAllSpellEvents();
    }
}
