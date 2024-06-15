package faang.school.godbless.Spell;



public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        String result = spellAction.perform(spellName);
        System.out.println(result);
    }
}




