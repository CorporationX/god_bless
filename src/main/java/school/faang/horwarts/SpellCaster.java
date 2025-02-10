package school.faang.horwarts;

public class SpellCaster {

    public void cast(String spellName, SpellAction spellAction) {
        if (spellName == null || spellAction == null) {
            return;
        }
        System.out.println("Spell result: " + spellAction.actTheSpell(spellName));
    }
}
