package faang.school.godbless.lambda.hogvards;

public class SpellCaster {

    public void cast(String spellName, SpellAction spellAction) {
        String result = spellAction.execute(spellName);
        System.out.println("Casting " + spellName + ": " + result);
    }
}
