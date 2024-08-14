package faang.school.godbless.javalambda.task7;

@FunctionalInterface
public interface Calculator<T extends Number> {
    T action(T t, T r);
}
