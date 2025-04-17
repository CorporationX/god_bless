package school.faang.hogwarts;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("Attack", "Damaging");
        hogwartsSpells.addSpellEvent("Fireball", "fire in a face");
        hogwartsSpells.addSpellEvent("Sunstrike", "sun on a head");
        hogwartsSpells.addSpellEvent("Snowwall", "add a snow wall");
        System.out.println();
        System.out.println(hogwartsSpells.getSpellEventById(3));
        System.out.println(hogwartsSpells.getSpellEventsByType("Fireball"));

        hogwartsSpells.deleteSpellEvent(2);
        System.out.println();
        hogwartsSpells.printAllSpellEvents();
        System.out.println();
    }
}
