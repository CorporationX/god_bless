package school.faang.catching_events;

public class HogwartsSpellsTest {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("firebole", "bah");
        hogwartsSpells.addSpellEvent("acebolt", "frezz");
        hogwartsSpells.addSpellEvent("heal", "hp up");
        hogwartsSpells.addSpellEvent("firebole", "ba");
        hogwartsSpells.printAllSpellEvents();
        System.out.println(hogwartsSpells.getSpellEventById(2) + "\n");
        hogwartsSpells.deleteSpellEvent(2);
        System.out.println(hogwartsSpells.getSpellEventsByType("firebole") + "\n");
        hogwartsSpells.printAllSpellEvents();
    }
}
