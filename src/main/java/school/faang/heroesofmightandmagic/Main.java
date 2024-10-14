package school.faang.heroesofmightandmagic;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Create heroes
        Hero hero1 = new Hero("Arthur", "Castle");
        Hero hero2 = new Hero("Morgan", "Rampart");

        // Add creatures to hero1's army
        hero1.addCreature(new Pikeman(0), 50);
        hero1.addCreature(new Griffin(0), 30);

        // Add creatures to hero2's army
        hero2.addCreature(new Swordman(0), 40);
        hero2.addCreature(new Angel(0), 5);

        // Display armies
        System.out.println("Hero 1 Army:");
        displayArmy(hero1.getArmy());

        System.out.println("\nHero 2 Army:");
        displayArmy(hero2.getArmy());

        // Create a battlefield and simulate a battle
        Battlefield battlefield = new Battlefield(hero1, hero2);
        battlefield.battle();
    }

    // Utility method to display a hero's army
    public static void displayArmy(Map<String, Creature> army) {
        for (Creature creature : army.values()) {
            System.out.println(creature.getName() + " (Quantity: " + creature.getQuantity() + ")");
        }
    }
}

