package school.faang.sprint2.task_45724;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        if (spellName == null) {
            throw new IllegalArgumentException("Spell name is null");
        }
        if (action == null) {
            throw new IllegalArgumentException("Spell action is null");
        }
        String result = action.castSpell(spellName);
        System.out.println("Результат заклинания: " + result);
    }
}
