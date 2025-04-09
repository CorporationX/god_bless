package school.faang.catchevents;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent("Защита", "Защищает");
        hogwartsSpells.addSpellEvent("Атака", "Атакует в ближнем бою");
        hogwartsSpells.addSpellEvent("Атака", "Атакует c воздуха");

        hogwartsSpells.printAllSpellEvents();

        System.out.println(hogwartsSpells.getSpellEventById(1));
        System.out.println(hogwartsSpells.getSpellEventsByType("Атака"));
        hogwartsSpells.getSpellEventById(5);
        System.out.println(hogwartsSpells.getSpellEventsByType("Прыгает"));

        hogwartsSpells.deleteSpellEvent(1);

        hogwartsSpells.printAllSpellEvents();
    }
}