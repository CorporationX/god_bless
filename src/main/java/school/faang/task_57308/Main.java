package school.faang.task_57308;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("Defense", "Defense from enemy attack");
        hogwartsSpells.addSpellEvent("Attack", "Attack your enemy");
        hogwartsSpells.addSpellEvent("Shout", "Shout at your enemy");
        hogwartsSpells.getSpellEventById(1);
        hogwartsSpells.getSpellEventsByType("Defense");
        hogwartsSpells.printAllSpellEvents();
        hogwartsSpells.deleteSpellEvent(2);
        hogwartsSpells.printAllSpellEvents();
    }
}
