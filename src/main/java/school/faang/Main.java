package school.faang;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent("Attack", "Fire attack");
        hogwartsSpells.addSpellEvent("Defence", "Water defence");

        hogwartsSpells.printAllSpellEvents();
        System.out.println();

        System.out.println(hogwartsSpells.getSpellEventById(2));
        System.out.println();
        System.out.println(hogwartsSpells.getSpellEventsByType("Attack"));
        System.out.println();
        hogwartsSpells.deleteSpellEvent(1);
        hogwartsSpells.printAllSpellEvents();
    }
}
