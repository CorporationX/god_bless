package school.faang.BJS2_85936;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells spells = new HogwartsSpells();
        spells.addSpellEvent("char", "became frog");
        spells.addSpellEvent("char", "fireball");
        System.out.println(spells.getSpellEventsByType("char"));
        spells.addSpellEvent("defence", "wall");
        spells.deleteSpellEvent(2);
        spells.addSpellEvent("tran", "became frog");
        spells.printAllSpellEvents();
    }
}
