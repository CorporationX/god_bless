package school.faang.task_44657;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells spellSystem = new HogwartsSpells();

        spellSystem.addSpellEvent(1, "Char", "Lifts objects into the air");
        spellSystem.addSpellEvent(2, "Protection", "Creates a shield against attacks");
        spellSystem.addSpellEvent(3, "Transfiguration", "Transforms an item into another");
        spellSystem.addSpellEvent(4, "Char", "Opens doors without a key");

        spellSystem.getSpellEventById(2);

        System.out.println("Spells of type 'Char':");
        spellSystem.getSpellEventsByType("Char").forEach(System.out::println);

        spellSystem.deleteSpellEvent(1);

        System.out.println("All spells:");
        spellSystem.printAllSpellEvents();
    }
}
