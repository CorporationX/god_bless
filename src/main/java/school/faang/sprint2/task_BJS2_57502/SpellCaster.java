package school.faang.sprint2.task_BJS2_57502;

public class SpellCaster {
    public void cast(String spell, SpellAction action) {
        checkSpell(spell);
        checkSpellAction(action);

        System.out.println(action.act(spell));
    }

    private void checkSpell(String spell) {
        if (spell == null || spell.isBlank()) {
            throw new IllegalArgumentException("Заклинание не может быть пустым");
        }
    }

    private void checkSpellAction(SpellAction action) {
        if (action == null) {
            throw new IllegalArgumentException("Действие не может быть пустым");
        }
    }
}
