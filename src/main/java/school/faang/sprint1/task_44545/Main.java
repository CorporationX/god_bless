package school.faang.sprint1.task_44545;

public class Main {
    public static void main(String[] args) {

        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("type2", "action1");
        System.out.println(
            hogwartsSpells.getSpellEventById(1)
        );
        hogwartsSpells.addSpellEvent("type2", "action2");
        System.out.println(
                hogwartsSpells.getSpellEventsByType("type2")
        );
        hogwartsSpells.printAllSpellEvents();
    }
}
