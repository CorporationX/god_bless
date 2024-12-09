package school.faang.sprint_2.task_45500;

public class SpellCaster {

    public void cast(String spell, SpellAction action) {
        System.out.println("Casting " + spell);
        System.out.println(action.cast(spell));
    }
}
