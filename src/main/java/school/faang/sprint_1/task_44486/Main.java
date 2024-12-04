package school.faang.sprint_1.task_44486;

public class Main {
    public static void main(String[] args) {
        var spells = new HogwartsSpells();
        spells.addSpellEvent(2, "Intelligence", "Give intelligence");
        spells.addSpellEvent(3, "Shield", "Give a shield");
        spells.addSpellEvent(1, "Health", "Give a health");
        spells.addSpellEvent(5, "Health", "Give a more health");
        spells.addSpellEvent(6, "Health", "Give a little health");
        spells.addSpellEvent(7, "Shield", "Give a big shield");

        System.out.println("Health events: " + spells.getSpellEventsByType("Health"));
        spells.printAllSpellEvents();

        spells.deleteSpellEvent(2);
        System.out.println("---------------DELETE EVENT-----------------");
        spells.printAllSpellEvents();

        System.out.println("Event 1: " + spells.getSpellEventById(1));
    }
}
