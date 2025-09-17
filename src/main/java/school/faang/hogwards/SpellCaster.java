package school.faang.hogwards;

/**
 * Проект: god_bless
 * Класс SpellCaster
 * Автор: Vital
 * Дата: 16.09.2025
 */

public class SpellCaster {
    public void cast(String spell, SpellAction action) {
        String result = action.act(spell);
        System.out.println(result);
    }
}