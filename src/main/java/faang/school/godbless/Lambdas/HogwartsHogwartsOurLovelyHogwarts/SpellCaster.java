package faang.school.godbless.Lambdas.HogwartsHogwartsOurLovelyHogwarts;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        String result = spellAction.performAction(spellName);
        System.out.println(result);
    }
}
