package school.faang;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent("Charm", "Creates light at the tip of the wand");
        hogwartsSpells.addSpellEvent("Defense", "Shields the caster from attacks");
        hogwartsSpells.addSpellEvent("Transfiguration", "Transforms an object into another");
        hogwartsSpells.addSpellEvent("Transfiguration", "Transforms an object into an animal");

        System.out.println("Get by ID 2:");
        System.out.println(hogwartsSpells.getSpellEventById(2));

        hogwartsSpells.printAllSpellEvents();

        System.out.println("Get by Type 'Transfiguration':");
        System.out.println(hogwartsSpells.getSpellEventsByType("Transfiguration"));

        System.out.println("Remove third event:");
        hogwartsSpells.deleteSpellEvent(3);

        hogwartsSpells.printAllSpellEvents();

    }
}
