package school.faang.BJS2_57026;

public class Main {
    public static void main(String[] args) {
        System.out.println("🔮 Welcome to the Hogwarts Spell System! 🔮\n");

        System.out.println("✨ Adding spells...\n");
        HogwartsSpells.addSpellEvent("Charms", "Levitates objects");
        HogwartsSpells.addSpellEvent("Charms", "Protects against dark forces");
        HogwartsSpells.addSpellEvent("Transfiguration", "Transforms an object");
        HogwartsSpells.addSpellEvent("Defense", "Reflects enemy attacks");

        System.out.println("\n🔍 List of all spells:");
        HogwartsSpells.printAllSpellEvents();

        System.out.println("\n🔍 Searching for spell with ID 1:");
        HogwartsSpells.getSpellEventById(1);

        System.out.println("\n🔍 Searching for spell with ID 99:");
        HogwartsSpells.getSpellEventById(99);

        System.out.println("\n🔍 Spells of type \"Charms\":");
        HogwartsSpells.getSpellEventsByType("Charms");

        System.out.println("\n🔍 Spells of type \"Necromancy\":");
        HogwartsSpells.getSpellEventsByType("Necromancy");


        System.out.println("\n🗑️ Deleting spell with ID 1:");
        HogwartsSpells.deleteSpellEvent(1);

        System.out.println("\n🔍 Checking if spell with ID 1 is deleted:");
        HogwartsSpells.getSpellEventById(1);


        System.out.println("\n🔍 Remaining spells:");
        HogwartsSpells.printAllSpellEvents();

        System.out.println("\n🗑️ Deleting remaining spells...");
        HogwartsSpells.deleteSpellEvent(2);
        HogwartsSpells.deleteSpellEvent(3);
        HogwartsSpells.deleteSpellEvent(4);

        System.out.println("\n🔍 Checking if the spell system is empty:");
        HogwartsSpells.printAllSpellEvents();

        System.out.println("\n🎉 All tests completed successfully! 🎉");
    }
}
