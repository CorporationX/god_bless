package school.faang.hogwarts;

public class SpellCaster {
    public void cast(String spell, SpellAction spellAction) {
        checkSpell(spell);
        checkSpellAction(spellAction);
        System.out.println(spellAction.cast(spell));
    }

    public void checkSpell(String spell) {
        if (spell == null || spell.isBlank()) {
            throw new IllegalArgumentException("Название заклинания не должно быть пустым");
        }
    }

    public void checkSpellAction(SpellAction spellAction) {
        if (spellAction == null) {
            throw new IllegalArgumentException("Действие заклинания не может быть null");
        }
    }
}