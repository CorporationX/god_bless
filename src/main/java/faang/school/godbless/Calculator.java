package faang.school.godbless;
@FunctionalInterface
public interface Calculator<T> {
    T apply(T a, T b);

}
