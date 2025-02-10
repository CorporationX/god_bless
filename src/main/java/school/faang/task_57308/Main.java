package school.faang.task_57308;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("Defense", "Defense from enemy attack");
        hogwartsSpells.addSpellEvent("Defense", "Strong defense");
        hogwartsSpells.addSpellEvent("Attack", "Attack your enemy");
        hogwartsSpells.addSpellEvent("Shout", "Shout at your enemy");
        System.out.println(hogwartsSpells.getSpellEventById(1));
        System.out.println(hogwartsSpells.getSpellEventsByType("Defense"));
        hogwartsSpells.printAllSpellEvents();
        hogwartsSpells.deleteSpellEvent(0);
        hogwartsSpells.deleteSpellEvent(1);
        System.out.println("aaa");
        hogwartsSpells.printAllSpellEvents();
    }
}
