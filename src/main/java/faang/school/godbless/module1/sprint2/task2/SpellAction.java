package faang.school.godbless.module1.sprint2.task2;

@FunctionalInterface
public interface SpellAction<T> {
    T castSpell(T spell);
}
