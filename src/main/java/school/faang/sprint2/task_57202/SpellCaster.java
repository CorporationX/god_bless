package school.faang.sprint2.task_57202;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        validateSpellName(spellName);
        validateAction(action);
        String result = action.castSpell(spellName);
        System.out.println("Результат заклинания: " + result);
    }

    private void validateSpellName(String spellName) {
        if (spellName == null || spellName.isBlank()) {
            throw new IllegalArgumentException("Spell name cant be null or empty");
        }
    }

    private void validateAction(SpellAction action) {
        if (action == null) {
            throw new IllegalArgumentException("Action cant be null");
        }
    }
}
