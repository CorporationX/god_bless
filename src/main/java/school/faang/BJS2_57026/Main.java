package school.faang.BJS2_57026;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        System.out.println("🔮 Welcome to the Hogwarts Spell System! 🔮\n");

        System.out.println("✨ Adding spells...\n");
        hogwartsSpells.addSpellEvent("Charms", "Levitates objects");
        hogwartsSpells.addSpellEvent("Charms", "Protects against dark forces");
        hogwartsSpells.addSpellEvent("Transfiguration", "Transforms an object");
        hogwartsSpells.addSpellEvent("Defense", "Reflects enemy attacks");

        System.out.println("\n🔍 List of all spells:");
        hogwartsSpells.printAllSpellEvents();

        System.out.println("\n🔍 Searching for spell with ID 1:");
        hogwartsSpells.getSpellEventById(1);

        System.out.println("\n🔍 Searching for spell with ID 99:");
        hogwartsSpells.getSpellEventById(99);

        System.out.println("\n🔍 Spells of type \"Charms\":");
        hogwartsSpells.getSpellEventsByType("Charms");

        System.out.println("\n🔍 Spells of type \"Necromancy\":");
        hogwartsSpells.getSpellEventsByType("Necromancy");


        System.out.println("\n🗑️ Deleting spell with ID 1:");
        hogwartsSpells.deleteSpellEvent(1);

        System.out.println("\n🔍 Checking if spell with ID 1 is deleted:");
        hogwartsSpells.getSpellEventById(1);


        System.out.println("\n🔍 Remaining spells:");
        hogwartsSpells.printAllSpellEvents();

        System.out.println("\n🗑️ Deleting remaining spells...");
        hogwartsSpells.deleteSpellEvent(2);
        hogwartsSpells.deleteSpellEvent(3);
        hogwartsSpells.deleteSpellEvent(4);

        System.out.println("\n🔍 Checking if the spell system is empty:");
        hogwartsSpells.printAllSpellEvents();

        System.out.println("\n🎉 All tests completed successfully! 🎉");
    }
}
