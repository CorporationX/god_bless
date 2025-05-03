package school.faang.bjs244699;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent(1, "Charm", "Wingardium Leviosa");
        hogwartsSpells.addSpellEvent(2, "Curse", "Avada Kedavra");
        hogwartsSpells.addSpellEvent(3, "Hex", "Rictusempra");
        hogwartsSpells.addSpellEvent(4, "Jinx", "Tarantallegra");
        hogwartsSpells.addSpellEvent(5, "Spell", "Expelliarmus");

        System.out.println("\nAll Spell Events:");
        hogwartsSpells.printAllSpellEvents();

        hogwartsSpells.deleteSpellEvent(2);

        System.out.println("\nAll Spell Events after deletion:");
        hogwartsSpells.printAllSpellEvents();

        List<SpellEvent> charmSpells = hogwartsSpells.getSpellEventsByType("Charm");
        System.out.println("\nSpell Events of type 'Charm':");
        for (SpellEvent event : charmSpells) {
            System.out.println(event);
        }

        System.out.println("\nGet Spell Event By Id");
        System.out.println(hogwartsSpells.getSpellEventById(3));
    }
}
