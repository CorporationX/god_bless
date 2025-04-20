package school.faang.bjs2_70423;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        System.out.println(spellAction.act(spellName));
    }
}