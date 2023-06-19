package faang.school.godbless.sprint3.task7;

public class SpellCaster {

    public void cast(String spell, SpellAction spellAction) {
        if (spell == null) {
            throw new NullPointerException("Заклинание не может быть пустым!");
        }
        if (spell.isBlank()) {
            throw new IllegalArgumentException("Заклинание не может быть пустым!");
        }
        System.out.println(spellAction.spell(spell));
    }
}
