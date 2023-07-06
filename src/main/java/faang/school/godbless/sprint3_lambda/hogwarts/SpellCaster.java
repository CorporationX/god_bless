package faang.school.godbless.sprint3_lambda.hogwarts;

public class SpellCaster {
    public void cast(String spell, SpellAction spellAction){
        spell = spellAction.cast(spell);
        System.out.println(spell);
    }
}
