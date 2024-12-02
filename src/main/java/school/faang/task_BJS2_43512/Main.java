package school.faang.task_BJS2_43512;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent(1, "magic", "fireball");
        hogwartsSpells.addSpellEvent(2, "magic", "frieze");
        hogwartsSpells.printAllSpellEvents();

        System.out.println(hogwartsSpells.getSpellEventById(1));

        System.out.println(hogwartsSpells.getSpellEventsByType("magic"));

        hogwartsSpells.deleteSpellEvent(2);

        hogwartsSpells.printAllSpellEvents();
    }
}
