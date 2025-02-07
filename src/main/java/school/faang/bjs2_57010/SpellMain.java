package school.faang.bjs2_57010;

public class SpellMain {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("Spell_1", "Action_1");
        hogwartsSpells.addSpellEvent("Spell_2", "Action_2");
        hogwartsSpells.addSpellEvent("Spell_1", "Action_4");
        hogwartsSpells.addSpellEvent("Spell_2", "Action_5");
        hogwartsSpells.addSpellEvent("Spell_3", "Action_3");

        try {
            System.out.println(hogwartsSpells.getSpellEventById(1));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        separator();

        System.out.println(hogwartsSpells.getSpellByType("Spell_2"));
        separator();

        hogwartsSpells.deleteSpellEvent(5);
        System.out.println(hogwartsSpells.getSpellByType("Spell_3"));
        separator();

        try {
            hogwartsSpells.getSpellEventById(5);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        separator();
        hogwartsSpells.printAllSpellEvents();
    }

    private static void separator() {
        System.out.println("=============================");
    }
}
