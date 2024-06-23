package faang.school.godbless.sprint_2.functional_interface.task_17_hogwarts;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction){
        System.out.println(spellAction.action(spellName));

    }
}
