package school.faang.hogwarts;

public class SpellCaster {
    public void cast(String nameSpell, SpellAction spellAction) {
        System.out.println("Заклинание " + spellAction.spellCast(nameSpell));
    }
}
