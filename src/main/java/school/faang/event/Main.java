package school.faang.event;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("Защита", "Щит из маны");
        hogwartsSpells.addSpellEvent("Защита", "Временная броня");
        hogwartsSpells.addSpellEvent("Атака", "Огненный шар");
        System.out.println(hogwartsSpells.getSpellEventsByType("Offense"));
        hogwartsSpells.deleteSpellEvent(2);
        System.out.println(hogwartsSpells.getSpellEventById(2));
        hogwartsSpells.printAllSpellEvents();
    }
}
