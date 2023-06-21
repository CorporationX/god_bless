package faang.school.godbless.kxnvg.calculator;

@FunctionalInterface
public interface Calculator<T> {

    T operation(T t, T l);
}