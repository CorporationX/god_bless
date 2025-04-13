package school.faang.bjs2_68757;

import static school.faang.bjs2_68757.SpellEventType.ENCHANTMENT;
import static school.faang.bjs2_68757.SpellEventType.PROTECTION;
import static school.faang.bjs2_68757.SpellEventType.TRANSFIGURATION;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        System.out.println("\nAdding spells:");
        hogwartsSpells.addSpellEvent(ENCHANTMENT, "An object lifted into the air");
        hogwartsSpells.addSpellEvent(TRANSFIGURATION, "The opponent lost consciousness");
        hogwartsSpells.addSpellEvent(PROTECTION, "The book flew up to the shelf");
        hogwartsSpells.addSpellEvent(ENCHANTMENT, "The chair turned into a rabbit");

        System.out.println("\nAll spells:");
        hogwartsSpells.printAllSpellEvents();

        try {
            System.out.println("\nSpell with ID 1:");
            System.out.println(hogwartsSpells.getSpellEventById(1));
        } catch (SpellEventNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            System.out.println("\nAll spells of type 'Levitation':");
            hogwartsSpells.getSpellEventsByType(PROTECTION).forEach(System.out::println);
        } catch (TypeSpellEventNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            System.out.println("\nDeleting spell with ID 2:");
            hogwartsSpells.deleteSpellEvent(2L);
        } catch (SpellEventNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            System.out.println("\nTrying to get deleted spell with ID 57:");
            hogwartsSpells.getSpellEventById(57L);
        } catch (SpellEventNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            System.out.println("\nTrying to get spells of type 'Invisibility':");
            hogwartsSpells.getSpellEventsByType(TRANSFIGURATION);
        } catch (TypeSpellEventNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("\nFinal list of spells:");
        hogwartsSpells.printAllSpellEvents();
    }
}
