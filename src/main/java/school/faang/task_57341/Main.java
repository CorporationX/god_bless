package school.faang.task_57341;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("Type", "Action");
        hogwartsSpells.addSpellEvent("Type2", "Action2");
        hogwartsSpells.addSpellEvent("Type3", "Action3");

        System.out.println(hogwartsSpells.getSpellEventById(1));
        System.out.println(hogwartsSpells.getSpellEventsByType("Type"));
        System.out.println(hogwartsSpells.deleteSpellEvent(1));
        hogwartsSpells.printAllSpellEvents();
    }
}
