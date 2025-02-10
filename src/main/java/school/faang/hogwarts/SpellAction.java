package school.faang.hogwarts;

/**
 * Функциональный интерфейс для выполнения заклинаний.
 */
@FunctionalInterface
public interface SpellAction {
    /**
     * Применяет заклинание и возвращает результат
     *
     * @param spell название заклинания
     * @return результат выполнения
     */
    String cast(String spell);
}
