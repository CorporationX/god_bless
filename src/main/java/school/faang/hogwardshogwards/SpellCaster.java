package school.faang.hogwardshogwards;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        System.out.println(spellAction.doAction(spellName));
    }
}
