package school.faang.BJS2_33711;

public class SpellCaster {
    public void cast(String spellNameInput, SpellAction spellAction) {
        System.out.println(spellAction.action(spellNameInput));
    }
}
