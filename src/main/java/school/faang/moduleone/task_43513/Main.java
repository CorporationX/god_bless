package school.faang.moduleone.task_43513;

public class Main {
    public static void main(String[] args) {
        SpellEvent spellEvent1 = new SpellEvent(1, "eventType1", "action1");
        SpellEvent spellEvent2 = new SpellEvent(2, "eventType1", "action2");
        SpellEvent spellEvent3 = new SpellEvent(3, "eventType2", "action3");

        HogwartsSpells hogwartsSpells = HogwartsSpells.getHogwartsSpells();

        hogwartsSpells.addSpellEvent(spellEvent1);
        hogwartsSpells.addSpellEvent(spellEvent2);
        hogwartsSpells.addSpellEvent(spellEvent3);

        showCondition(hogwartsSpells);

        System.out.println("spellEvent with id = 1 is: " + hogwartsSpells.getSpellEventById(1));
        System.out.println("spellEvent with id = 4 is: " + hogwartsSpells.getSpellEventById(4));
        System.out.println("All spells with eventType = eventType1 is: "
                + hogwartsSpells.getSpellEventsByType("eventType1"));
        showCondition(hogwartsSpells);
        System.out.println("Deleted spell with id = 3 is: " + hogwartsSpells.deleteSpellEvent(3));
        showCondition(hogwartsSpells);
        System.out.println("Deleted spell with id = 3 is: " + hogwartsSpells.deleteSpellEvent(3));
        showCondition(hogwartsSpells);
    }

    private static void showCondition(HogwartsSpells hogwartsSpells) {
        System.out.println("All Hogwarts spells: ");
        hogwartsSpells.printAllSpellEvents();
        System.out.println("*".repeat(50));
    }
}
