package faang.school.godbless.sprint2.lambda.hogwarts;

public class SpellCaster {

    public void cast(String spellName, SpellAction action) {
        System.out.println(action.use(spellName));
    }
}
