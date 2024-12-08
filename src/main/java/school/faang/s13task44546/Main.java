package school.faang.s13task44546;

public class Main {
    public static void main(String[] args) {

        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent(1, "protection", "protects against attacks");
        hogwartsSpells.addSpellEvent(2, "transfiguration", "transforms an item");

        hogwartsSpells.getSpellEventById(1);
        hogwartsSpells.getSpellEventsByType("transfiguration");
        hogwartsSpells.deleteSpellEvent(2);
        hogwartsSpells.printAllSpellEvents();
    }
}