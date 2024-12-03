package school.faang.sprint1.taskbjs243512;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent(1, "magic", "fireball");
        hogwartsSpells.addSpellEvent(2, "magic", "frieze");
        hogwartsSpells.addSpellEvent(3, "focus", "bunny");
        hogwartsSpells.addSpellEvent(4, "focus", "fox");

        hogwartsSpells.printAllSpellEvents();
        System.out.println("******");

        System.out.println(hogwartsSpells.getSpellEventById(4));
        System.out.println("******");

        System.out.println(hogwartsSpells.getSpellEventsByType("magic"));
        System.out.println("*******");

        System.out.println(hogwartsSpells.getSpellEventsByType("focus"));
        System.out.println("*******");

        hogwartsSpells.deleteSpellEvent(2);
        System.out.println("*******");

        hogwartsSpells.printAllSpellEvents();
    }
}
