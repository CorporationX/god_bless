package school.module1.task44498;

public class Main {

    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent(3, "Protection", "Protects from attacks");
        hogwartsSpells.addSpellEvent(1, "Enchantment", "Transforms an item");
        hogwartsSpells.addSpellEvent(2, "Protection", "Protects from attacks");

        hogwartsSpells.getSpellEventById(1);
        hogwartsSpells.getSpellEventsByType("Protection");

        hogwartsSpells.deleteSpellEvent(2);
        hogwartsSpells.printAllSpellEvents();
    }
}
