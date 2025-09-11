package school.faang.bjs2_91005;

public class SpellCaster {
    public static void cast(String spell, SpellAction spellAction) {
        System.out.println(spellAction.performSpell(spell));
    }
}
