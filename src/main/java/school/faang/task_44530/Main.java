package school.faang.task_44530;

public class Main {
    private static final HogwartsSpells hogwartsSpells = new HogwartsSpells();

    public static void main(String[] args) {
        hogwartsSpells.addSpellEvent(1, "a", "aa");
        hogwartsSpells.addSpellEvent(2, "b", "bb");
        hogwartsSpells.addSpellEvent(3, "c", "cc");
        hogwartsSpells.addSpellEvent(4, "d", "dd");
        hogwartsSpells.addSpellEvent(5, "a", "ee");
        hogwartsSpells.addSpellEvent(6, "b", "ff");

        printResult();

        hogwartsSpells.deleteSpellEvent(1);
        hogwartsSpells.deleteSpellEvent(4);
        printResult();

        System.out.println(hogwartsSpells.getSpellEventById(2));
    }

    private static void printResult() {
        System.out.println("AllSpellEvents:");
        hogwartsSpells.printAllSpellEvents();

        System.out.println("\nSpellEvents WHERE eventType=a:");
        hogwartsSpells.getSpellEventsByType("a").forEach(System.out::println);

        System.out.println("\nSpellEvents WHERE eventType=b:");
        hogwartsSpells.getSpellEventsByType("b").forEach(System.out::println);

        System.out.println("\n--------------------\n");
    }

}
