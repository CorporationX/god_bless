package school.faang.catchevents;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent(EventType.DEFENSE, "Защищает");
        hogwartsSpells.addSpellEvent(EventType.ATTACK, "Атакует в ближнем бою");
        hogwartsSpells.addSpellEvent(EventType.ATTACK, "Атакует c воздуха");

        hogwartsSpells.printAllSpellEvents();

        System.out.println(hogwartsSpells.getSpellEventById(1));
        System.out.println(hogwartsSpells.getSpellEventsByType(EventType.ATTACK));
        hogwartsSpells.getSpellEventById(5);
        System.out.println(hogwartsSpells.getSpellEventsByType(EventType.DEFENSE));

        hogwartsSpells.deleteSpellEvent(1);

        hogwartsSpells.printAllSpellEvents();
    }
}