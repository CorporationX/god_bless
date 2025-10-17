package school.faang.bjs286886;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent("Charm", "Levitation of objects");
        hogwartsSpells.addSpellEvent("Defense", "Protects from dark magic");
        hogwartsSpells.addSpellEvent("Transfiguration", "Transforms one object into another");
        hogwartsSpells.addSpellEvent("Charm", "Unlocks doors");

        System.out.println("All spells:");
        hogwartsSpells.printAllSpellEvents();

        System.out.println("Get spell by ID :");
        System.out.println(hogwartsSpells.getSpellEventById(2));

        System.out.println("Get all 'Charm' spells:");
        System.out.println(hogwartsSpells.getSpellEventsByType("Charm"));

        System.out.println("Delete spell with ID 1");
        hogwartsSpells.deleteSpellEvent(1);

        System.out.println("All spells after deletion:");
        hogwartsSpells.printAllSpellEvents();
    }
}
