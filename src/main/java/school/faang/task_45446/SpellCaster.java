package school.faang.task_45446;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        String result = action.castSpell(spellName);
        System.out.println("результат заклинания: " + result);
    }
}
