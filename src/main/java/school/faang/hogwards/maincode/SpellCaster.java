package school.faang.hogwards.maincode;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        System.out.println(spellAction.execute(spellName));
    }
}
