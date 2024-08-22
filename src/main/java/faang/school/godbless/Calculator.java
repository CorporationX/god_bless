package faang.school.godbless;

@FunctionalInterface
public interface Calculator<T extends Number> {
    public T calc(T t,T t2);
}
