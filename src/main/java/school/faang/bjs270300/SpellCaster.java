package school.faang.bjs270300;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        System.out.println(action.cast(spellName));
    }
}
