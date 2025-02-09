package school.faang.ourfavoritehogwarts;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        System.out.println(spellAction.act(spellName));
    }
}