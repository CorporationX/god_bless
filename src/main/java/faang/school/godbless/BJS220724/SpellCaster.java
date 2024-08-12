package faang.school.godbless.BJS220724;

public class SpellCaster {
    public static void cast(String spellName, SpellAction spellAction) {
        System.out.println(spellAction.describeSpell(spellName));
    }
}
