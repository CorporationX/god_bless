package school.faang.bjs2_80210;

public class SpellCaster {
    public void cast(String spell, SpellAction spellAction) {
        String result = spellAction.perform(spell);
        System.out.println(result);
    }
}
