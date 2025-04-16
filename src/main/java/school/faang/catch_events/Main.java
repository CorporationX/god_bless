package school.faang.catch_events;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        System.out.println("--- Test 1: Adding Spells ---");
        hogwartsSpells.addSpellEvent("Charm", "Levitates an object");
        hogwartsSpells.addSpellEvent("Transfiguration", "Turns a rat into a cup");
        hogwartsSpells.addSpellEvent("Defense", "Creates a shield against spells");
        hogwartsSpells.addSpellEvent("Charm", "Makes an object move");
        hogwartsSpells.printAllSpellEvents();

        System.out.println("\n--- Test 3: Getting Spells by Type ---");
        List<SpellEvent> charms = hogwartsSpells.getSpellEventsByType("Charm");
        System.out.println("\nSpells of type 'Charm':");
        for (SpellEvent spell : charms) {
            System.out.println("- " + spell);
        }
        List<SpellEvent> transfigurations = hogwartsSpells.getSpellEventsByType("Transfiguration");
        System.out.println("\nSpells of type 'Transfiguration':");
        for (SpellEvent spell : transfigurations) {
            System.out.println("- " + spell);
        }
        List<SpellEvent> healing = hogwartsSpells.getSpellEventsByType("Healing");
        System.out.println("\nSpells of type 'Healing':");
        for (SpellEvent spell : healing) {
            System.out.println("- " + spell);
        }

        System.out.println("\n--- Test 4: Deleting Spell by ID ---");
        hogwartsSpells.deleteSpellEvent(2);
        System.out.println("After deleting spell with ID 2:");
        hogwartsSpells.printAllSpellEvents();
        List<SpellEvent> transfigurationsAfterDelete = hogwartsSpells.getSpellEventsByType("Transfiguration");
        System.out.println("Spells of type 'Transfiguration' after deleting ID 2:");
        for (SpellEvent spell : transfigurationsAfterDelete) {
            System.out.println("- " + spell);
        }

        System.out.println("\n--- Test 5: Attempting to Delete a Non-Existent Spell ---");
        hogwartsSpells.deleteSpellEvent(99);
        System.out.println("After attempting to delete non-existent spell with ID 99:");
        hogwartsSpells.printAllSpellEvents();

        System.out.println("\n--- Test 6: Adding Another Spell After Deletion ---");
        hogwartsSpells.addSpellEvent("Defense", "Deflects physical attacks");
        hogwartsSpells.printAllSpellEvents();
        List<SpellEvent> defenseSpells = hogwartsSpells.getSpellEventsByType("Defense");
        System.out.println("Spells of type 'Defense':");
        for (SpellEvent spell : defenseSpells) {
            System.out.println("- " + spell);
        }
    }
}
