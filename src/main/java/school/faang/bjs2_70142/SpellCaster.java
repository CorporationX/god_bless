package school.faang.bjs2_70142;

public class SpellCaster {
    public void cast(String spell, SpellAction spellAction) {
        if (spellAction == null) {
            throw new IllegalArgumentException("spell action is null");
        }
        System.out.println(spellAction.castSpell(spell));
    }
}
