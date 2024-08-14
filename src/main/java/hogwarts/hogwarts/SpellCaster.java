package hogwarts.hogwarts;

public class SpellCaster {

    public void cast(String spellName, SpellAction spellAction) {
        String spellCast = spellAction.action(spellName);
        System.out.println(spellCast);
    }
}
