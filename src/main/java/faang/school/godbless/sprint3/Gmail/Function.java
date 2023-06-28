package faang.school.godbless.sprint3.Gmail;

@FunctionalInterface
public interface Function<T,N> {
    N act(T tmp);
}
