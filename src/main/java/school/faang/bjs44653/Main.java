package school.faang.bjs44653;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent(13, "Defence", "Defence owner from dragons");
        hogwartsSpells.addSpellEvent(3, "Defence", "Defence owner from bullies");
        hogwartsSpells.addSpellEvent(24, "Charm", "Levitation charm for objects");
        hogwartsSpells.addSpellEvent(5, "Transfiguration", "Transform object into animal");

        System.out.println(hogwartsSpells.getSpellEventById(3));
        hogwartsSpells.deleteSpellEvent(5);
        System.out.println(hogwartsSpells.getSpellEventsByType("Defence"));
        hogwartsSpells.printAllSpellEvents();
        System.out.println(hogwartsSpells.getSpellEventById(13));

        hogwartsSpells.deleteSpellEvent(24);
        hogwartsSpells.deleteSpellEvent(13);
        hogwartsSpells.printAllSpellEvents();
    }
}
