package school.faang.bjs2_70142;

public class SpellCaster {
    public void cast(String spell, SpellAction spellAction) {
        if (spellAction == null) {
            throw new NullPointerException("spell action is null");
        }
        System.out.println(spellAction.spellAction(spell));
    }
}
