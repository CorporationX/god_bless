package faang.school.godbless.Sprint3.Gmail;

@FunctionalInterface
public interface Function<T,N> {
    N act(T tmp);
}
