package faang.school.godbless.LambdaStreamApi.Hogwarts;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        System.out.println(spellAction.doSpell(spellName));
    }
}
