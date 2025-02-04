package school.faang;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent("Transfiguration", "Transforms an object");
        hogwartsSpells.addSpellEvent("Protection", "Creates a protective barrier");
        hogwartsSpells.addSpellEvent("Enchantment", "Protects against attacks");

        System.out.println("All spells:");
        hogwartsSpells.printAllSpellEvents();

        System.out.println("\nSpell with ID 2:");
        SpellEvent spellEventById = hogwartsSpells.getSpellEventById(2);
        System.out.println(spellEventById.toString());

        System.out.println("\nSpells type 'Protection':");
        List<SpellEvent> protection = hogwartsSpells.getSpellsByType("Protection");
        for (SpellEvent spellEvent : protection) {
            System.out.println(spellEvent);
        }

        hogwartsSpells.deleteSpellEventById(1);
        System.out.println("Deleting a spell with ID 1:");
        hogwartsSpells.printAllSpellEvents();

    }
}
