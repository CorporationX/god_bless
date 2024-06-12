package faang.school.godbless.lambdas.hogwarts;

public class SpellCaster {
    public void cast(String spell, SpellAction action) {
        System.out.println(action.doAction(spell));
    }
}
