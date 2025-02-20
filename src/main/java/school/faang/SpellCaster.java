package school.faang;

public class SpellCaster {
    public void cast(String spell, SpellAction action) {
        checkSpell(spell);
        checkSpellAction(action);

        System.out.println(action.act(spell));
    }

    private void checkSpell(String spell) {
        if (spell == null || spell.isBlank()) {
            throw new IllegalArgumentException("Заклиание не должно быть пустым");

        }
    }


    @SuppressWarnings("checkstyle:NeedBraces")
    private void checkSpellAction(SpellAction action) {
        if (action == null) ;
        throw new IllegalArgumentException("Действие не должно быть пустым");
    }
}

