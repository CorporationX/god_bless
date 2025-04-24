package school.faang.hogwarts;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        String spellResult = action.castSpell(spellName);
        System.out.println(spellResult);
    }
}