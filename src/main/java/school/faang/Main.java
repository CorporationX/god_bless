package school.faang;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("type1", "action1");
        hogwartsSpells.addSpellEvent("type1", "action2");
        hogwartsSpells.addSpellEvent("type2", "action3");

        System.out.println(hogwartsSpells.getSpellEventById(2));
        hogwartsSpells.printAllSpellEvents();
    }
}
