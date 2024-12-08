package school.faang.task_44644;

public class Main {

    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent(4, "lumos", "gives the light");
        hogwartsSpells.addSpellEvent(6, "transfiguration", "transforms an item");
        hogwartsSpells.addSpellEvent(8, "protection", "protects from attacks");
        hogwartsSpells.addSpellEvent(9, "expecto patronum", "repels Dementors");
        hogwartsSpells.printAllSpellEvents();
        hogwartsSpells.getSpellEventById(9);
        hogwartsSpells.getSpellEventsByType("lumos");
        hogwartsSpells.deleteSpellEvent(6);
        hogwartsSpells.printAllSpellEvents();
    }
}