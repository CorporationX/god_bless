package school.faang.sprint_2.task_45466;

public class SpellCaster {

    public void cast(String spellName, SpellAction action) {
        String result = action.castSpell(spellName);
        System.out.println("Результат заклинания: " + result);
    }
}
