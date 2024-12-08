package school.faang.lovely_hogwarts;

public class SpellCaster {

    public void cast(String spellName, SpellAction spellAction) {
        String resultOfSpell = spellAction.spellCast(spellName);
        System.out.println("The spell was cast - " + resultOfSpell);
    }
}
