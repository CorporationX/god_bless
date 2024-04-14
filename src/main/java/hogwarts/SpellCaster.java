package hogwarts;

public class SpellCaster {
    public void cast(String spellTitle, SpellAction spellAction) {
        System.out.println(spellAction.action(spellTitle));
    }
}
