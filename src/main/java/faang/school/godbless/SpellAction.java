package faang.school.godbless;

@FunctionalInterface
public interface SpellAction<T> {
    T execute(T name);
}
