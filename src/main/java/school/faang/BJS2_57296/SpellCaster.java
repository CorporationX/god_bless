package school.faang.BJS2_57296;

public class SpellCaster {

    public void cast(String spell, SpellAction action) {
        if (spell == null || spell.isBlank()) {
            throw new IllegalArgumentException("Заклинание не может быть пустым или null");
        }
        System.out.println(action.castSpell(spell));
    }
}
