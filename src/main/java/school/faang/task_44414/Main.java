package school.faang.task_44414;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent(13, "exampleType1", "action1");
        hogwartsSpells.addSpellEvent(3, "exampleType2", "action2");
        hogwartsSpells.addSpellEvent(42, "exampleType3", "action3");
        hogwartsSpells.addSpellEvent(64, "exampleType4", "action4");
        hogwartsSpells.addSpellEvent(123, "", "action5");
        hogwartsSpells.addSpellEvent(44, "", "");
        hogwartsSpells.addSpellEvent(22, null, null);

        hogwartsSpells.printAllSpellEvents();

        System.out.println(hogwartsSpells.getSpellEventById(64));
        System.out.println(hogwartsSpells.getSpellEventById(12));
        System.out.println(hogwartsSpells.getSpellEventsByType(null));
        System.out.println(hogwartsSpells.getSpellEventsByType("exampleType4"));

        hogwartsSpells.deleteSpellEvent(123);
        hogwartsSpells.printAllSpellEvents();
    }
}
