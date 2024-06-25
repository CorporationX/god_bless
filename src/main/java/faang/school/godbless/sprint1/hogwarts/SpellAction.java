package faang.school.godbless.sprint1.hogwarts;

/**
 * @author Evgenii Malkov
 */
public interface SpellAction<T> {

  T doSpell(T spell);
}
