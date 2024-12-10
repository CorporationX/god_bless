package school.faang.bjs245505;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        System.out.println(action.act(spellName));
    }
}
