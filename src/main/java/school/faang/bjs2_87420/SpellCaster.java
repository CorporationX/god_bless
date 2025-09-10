package school.faang.bjs2_87420;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        System.out.println(spellAction.doAction(spellName));
    }
}
