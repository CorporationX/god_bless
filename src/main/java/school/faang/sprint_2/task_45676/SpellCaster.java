package school.faang.sprint_2.task_45676;

public class SpellCaster {
    public void cast(String nameSpell, SpellAction action) {
        System.out.println("Результат заклинания: " + action.cast(nameSpell));
    }
}
