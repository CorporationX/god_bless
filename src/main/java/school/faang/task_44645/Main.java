package school.faang.task_44645;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells spells = new HogwartsSpells();

        spells.addSpellEvent(1, "Charm", "Used to open doors");
        spells.addSpellEvent(2, "Curse", "Causes uncontrollable babbling");
        spells.addSpellEvent(3, "Curse", "Removes the victim's hair");
        spells.printAllSpellEvents();

        System.out.println();
        System.out.println(spells.getSpellEventById(1));

        System.out.println();
        System.out.println(spells.getSpellEventsByType("Curse"));

        System.out.println();
        spells.deleteSpellEvent(2);
        spells.printAllSpellEvents();
    }
}
