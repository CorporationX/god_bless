package module_2.module_2_1_Lambda.hogvarts_hogvarts;

public class SpellCaster {
    public static void cast(String spell, SpellAction action) {
        System.out.println("Результат заклинания: " + action.castSpell(spell));
    }
}
