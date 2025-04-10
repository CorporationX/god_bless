package school.faang.CatchingEvents;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("Защита", "Защищает от кашля");
        hogwartsSpells.addSpellEvent("Атака", "Щелбан");
        hogwartsSpells.addSpellEvent("Защита", "Защищает от сглаза");
        hogwartsSpells.printAllSpellEvents();

        System.out.println(hogwartsSpells.getSpellEventById(1));
        System.out.println(hogwartsSpells.getSpellEventById(5));

        System.out.println(hogwartsSpells.getSpellEventsByType("Защита"));
        System.out.println(hogwartsSpells.getSpellEventsByType("Чары"));

        hogwartsSpells.deleteSpellEvent(1);
        hogwartsSpells.deleteSpellEvent(17);
        hogwartsSpells.printAllSpellEvents();
    }
}
