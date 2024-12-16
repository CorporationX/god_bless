package school.faang.task_44688;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        System.out.println("\n### Adding spell events:");
        hogwartsSpells.addSpellEvent("Defense", "Casts a protective shield around all allies");
        hogwartsSpells.addSpellEvent("Attack", "Launches a fireball that targets all enemies");
        hogwartsSpells.addSpellEvent("Attack", "Unleashes a powerful lightning strike on a single target");
        hogwartsSpells.addSpellEvent("Block", "Creates a magical barrier to block incoming attacks");

        System.out.println("\n### Retrieving spell event by ID:");
        System.out.println("Spell with ID 1: " + hogwartsSpells.getSpellEventById(1));
        System.out.println("Spell with ID 2: " + hogwartsSpells.getSpellEventById(2));

        System.out.println("\n### Retrieving spell events by type:");
        System.out.println("Spells of type 'Attack': " + hogwartsSpells.getSpellEventsByType("Attack"));
        System.out.println("Spells of type 'Defense': " + hogwartsSpells.getSpellEventsByType("Defense"));
        System.out.println("Spells of type 'Block': " + hogwartsSpells.getSpellEventsByType("Block"));

        System.out.println("\n### Deleting a spell event by ID:");
        hogwartsSpells.deleteSpellEvent(2);
        hogwartsSpells.deleteSpellEvent(3);

        System.out.println("\n### Printing all spell events:");
        hogwartsSpells.printAllSpellEvents();

        System.out.println("\n### Printing spell events (simple list):");
        hogwartsSpells.printSpellEvents();

        System.out.println("\n### Printing spell events grouped by type:");
        hogwartsSpells.printSpellEventsByType();
    }
}