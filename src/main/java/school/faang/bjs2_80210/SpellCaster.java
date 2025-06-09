package school.faang.bjs2_80210;

public class SpellCaster {
    public void cast(String spell, SpellAction spellAction) {
        String result = spellAction.action(spell);
        System.out.println(result);
    }
}
