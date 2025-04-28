package school.faang.hogwarts;

public class SpellCaster {
    public void cast(String spell, SpellAction action) {
        String result = action.castSpell(spell);
        System.out.printf("Результат: %s", result);
    }
}
