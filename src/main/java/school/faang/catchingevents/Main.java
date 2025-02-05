package school.faang.catchingevents;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent("Enchantment", "Accio");
        hogwartsSpells.addSpellEvent("Transfiguration", "Reparo");
        hogwartsSpells.addSpellEvent("Enchantment", "Alohomora");
        hogwartsSpells.addSpellEvent("Transfiguration", "Glisseo");
        hogwartsSpells.addSpellEvent("Transfiguration", "Aguamenti");
        hogwartsSpells.addSpellEvent("Transfiguration", "Pullus");
        hogwartsSpells.addSpellEvent("Defense", "Protego");

        hogwartsSpells.printAllSpellEvents();

        hogwartsSpells.getSpellEventById(101);
        hogwartsSpells.deleteSpellEvent(101);
        hogwartsSpells.printAllSpellEvents();
        hogwartsSpells.getSpellEventById(101);

        hogwartsSpells.addSpellEvent("Transfiguration", "Reparo");
        hogwartsSpells.printAllSpellEvents();

        hogwartsSpells.getSpellEventsByType("Transfiguration");
    }
}
