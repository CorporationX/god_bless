package faang.school.godbless.Hogwarts;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction){
        String result = spellAction.castSpell(spellName);
        System.out.println(result);
    }
}
