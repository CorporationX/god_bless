package school.faang.bjs2_70274;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        System.out.println(action.cast(spellName));
    }
}