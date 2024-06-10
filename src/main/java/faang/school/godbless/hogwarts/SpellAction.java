package faang.school.godbless.hogwarts;

/**
 * @author Evgenii Malkov
 */
public interface SpellAction<T> {

  T doSpell(T spell);
}
