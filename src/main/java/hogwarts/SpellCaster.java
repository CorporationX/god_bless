package hogwarts;

public class SpellCaster {

    public void cast(String spell, SpellAction spellAction) {
        String spellName = spellAction.castSpell(spell);
        System.out.println("Результат заклинания: " + spellName);
    }
}
