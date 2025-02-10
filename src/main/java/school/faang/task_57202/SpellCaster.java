package school.faang.task_57202;

public class SpellCaster {
    void cast(String spellName, SpellAction action) {
        String result = action.castSpell(spellName);
        System.out.println("Результат заклинания: " + result);
    }
}
