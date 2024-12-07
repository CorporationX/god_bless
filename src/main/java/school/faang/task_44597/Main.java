package school.faang.task_44597;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent(1, "Enchantment", "Transforms an object");
        hogwartsSpells.addSpellEvent(2, "Protection", "Protects against attacks");
        hogwartsSpells.addSpellEvent(3, "Enchantment", "Gives strength");

        hogwartsSpells.printAllSpellEvents();

        hogwartsSpells.getSpellEventById(3);
        hogwartsSpells.getSpellEventsByType("Enchantment");
        hogwartsSpells.getSpellEventsByType("Protection");
        hogwartsSpells.getSpellEventById(5);
        hogwartsSpells.getSpellEventsByType("Transfiguration");

        hogwartsSpells.deleteSpellEvent(3);
        hogwartsSpells.deleteSpellEvent(900);
        hogwartsSpells.printAllSpellEvents();

    }
}
