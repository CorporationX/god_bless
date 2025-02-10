package BJS2_57266;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("spell", "Accio");
        hogwartsSpells.addSpellEvent("spell", "Expelliarmus");
        hogwartsSpells.addSpellEvent("spell", "Expecto Patronum");

        hogwartsSpells.printAllSpellEvents();
        System.out.println("------------------------------------");
        System.out.println(hogwartsSpells.getSpellEventById(2));
        System.out.println("------------------------------------");
        hogwartsSpells.deleteSpellEvent(2);
        hogwartsSpells.printAllSpellEvents();
        System.out.println("------------------------------------");
        System.out.println(hogwartsSpells.getSpellEventsByType("spell"));
        System.out.println("------------------------------------");
        hogwartsSpells.addSpellEvent("spell", "Stupefy");
        hogwartsSpells.printAllSpellEvents();
    }
}
