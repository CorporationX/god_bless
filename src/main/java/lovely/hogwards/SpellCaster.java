package lovely.hogwards;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        System.out.println(spellAction.spell(spellName));
    }
}
