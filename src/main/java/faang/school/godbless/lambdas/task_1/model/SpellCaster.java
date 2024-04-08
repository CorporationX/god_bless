package faang.school.godbless.lambdas.task_1.model;

public class SpellCaster {
    public void cast(String spell, SpellAction<String> action) {
        System.out.println(action.pronounce(spell));
    }
}