package school.faang;

public class SpellCaster {

    public void cast(String spellName, SpellAction spellAction) {
        System.out.println("Результат заклинания " + spellAction.castSpell(spellName));
    }
}
