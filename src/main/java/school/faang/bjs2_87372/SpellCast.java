package school.faang.bjs2_87372;

public class SpellCast {
    public void cast(String spellName, SpellAction spellAction) {
        String result = spellAction.castSpell(spellName);
        System.out.println(result.toUpperCase());
    }
}
