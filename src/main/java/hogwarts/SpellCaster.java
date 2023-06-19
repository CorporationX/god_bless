package hogwarts;

public class SpellCaster {
    public static void cast(String spell, SpellAction spellAction) {
        System.out.println(spellAction.result(spell));
    }
}
