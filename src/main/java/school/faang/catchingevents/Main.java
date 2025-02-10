package school.faang.catchingevents;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent("Charms", "Wingardium Leviosa");
        hogwartsSpells.addSpellEvent("Curses", "Cruciatus");
        hogwartsSpells.addSpellEvent("Charms", "Accio");
        hogwartsSpells.addSpellEvent("Transfiguration", "Spell1");
        hogwartsSpells.getSpellEventById(2);
        hogwartsSpells.getSpellEventsByType("Charms");
        hogwartsSpells.deleteSpellEvent(2);
        hogwartsSpells.printAllSpellEvents();

    }
}
