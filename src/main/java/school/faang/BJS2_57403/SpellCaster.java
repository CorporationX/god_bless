package school.faang.BJS2_57403;

public class SpellCaster {
    public void cast(String nameSpell, SpellAction spellAction) {
        System.out.printf("%s\n", spellAction.castSpell(nameSpell));
    }
}
