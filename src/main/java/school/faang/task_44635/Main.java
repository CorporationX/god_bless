package school.faang.task_44635;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent(1, "Healing", "Heals wounds");
        hogwartsSpells.addSpellEvent(2, "Divination", "Reveals future events");
        hogwartsSpells.addSpellEvent(5, "Dark Arts", "Curses and hexes");

        hogwartsSpells.printAllSpellEvents();
    }
}
