package school.faang.catchingeventsbjs44586;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent(1, "Enchantment", "Protects against attacks");
        hogwartsSpells.addSpellEvent(2, "Transfiguration", "Transforms an object");
        hogwartsSpells.addSpellEvent(3, "Protection", "Creates a magic barrier");
        hogwartsSpells.addSpellEvent(4, "Enchantment", "Increases power");

        System.out.println("All event spells:");
        HogwartsSpells.printAllSpellEvents();

        System.out.println("Event with id 2:");
        System.out.println(hogwartsSpells.getSpellEvent(2));

        System.out.println("Event with type Enchantment:");
        System.out.println(hogwartsSpells.getSpellEventsByType("Enchantment"));

        hogwartsSpells.deleteSpellEvent(4);
    }
}
