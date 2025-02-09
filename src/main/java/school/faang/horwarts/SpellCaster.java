package school.faang.horwarts;

public class SpellCaster {

    public void cast(String spellName, SpellAction spellAction) {
        String result = spellAction.actTheSpell(spellName);
        System.out.println("Spell result: " + result);
    }
}
