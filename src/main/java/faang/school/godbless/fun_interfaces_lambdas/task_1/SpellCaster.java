package faang.school.godbless.fun_interfaces_lambdas.task_1;

public class SpellCaster {
    void cast(String spellName, SpellAction action) {
        System.out.println(action.act(spellName));
    }
}
