package faang.school.godbless.sprint2.lambda.hogwarts;

public class SpellCaster {

    public void cast(String spellName, SpellAction action) {
        String result = action.use(spellName);
        System.out.println(result);
    }
}
