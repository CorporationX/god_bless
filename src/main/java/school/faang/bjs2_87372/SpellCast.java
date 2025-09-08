package school.faang.bjs2_87372;

public class SpellCast {
    public void cast(String spellName, SpellAction spellAction) {
        String result = spellAction.castSpell(spellName);
        StringBuilder sb = new StringBuilder(result);
        result = sb.reverse().toString();
        System.out.println(result.toUpperCase());
    }
}
