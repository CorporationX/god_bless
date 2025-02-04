package school.faang;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        System.out.println(hogwartsSpells.addSpellEvent("type1", "action1"));
        System.out.println(hogwartsSpells.addSpellEvent("type1", "action2"));
        System.out.println(hogwartsSpells.addSpellEvent("type2", "action3"));

        System.out.println(hogwartsSpells.deleteSpellEvent(-1));
        System.out.println(hogwartsSpells.getSpellEventById(2));
        hogwartsSpells.printAllSpellEvents();
    }
}
