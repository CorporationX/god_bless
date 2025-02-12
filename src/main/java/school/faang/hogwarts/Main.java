package school.faang.hogwarts;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("Expeliarmus", "Disarms an opponent");
        hogwartsSpells.addSpellEvent("Lumos", "Creates light");
        hogwartsSpells.addSpellEvent("Wingardium Leviosa", "Lifts objects");
        hogwartsSpells.addSpellEvent("Petrificus Totalus", "Paralyzes the target");
        hogwartsSpells.addSpellEvent("Alohomora", "Unlocks doors");

        System.out.println("All spells: ");

        System.out.println("\n Retrieving spell by ID 2: ");
        System.out.println(hogwartsSpells.getSpellEventById(2));

        System.out.println("\n Spells of type 'Charm': ");
        System.out.println(hogwartsSpells.getSpellEventsByType("Charm"));

        System.out.println("\n Deleting spell with ID 3...");
        hogwartsSpells.deleteSpellEvent(3);

        System.out.println("\n Updated list of spells:");
        hogwartsSpells.printAllSpellEvents();
    }
}

