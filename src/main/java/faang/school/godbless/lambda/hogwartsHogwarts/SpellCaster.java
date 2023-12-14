package faang.school.godbless.lambda.hogwartsHogwarts;

public class SpellCaster {
    public void cast(String spell, SpellAction spellAction) {
        System.out.println(spellAction.getSpell(spell));
    }
}
