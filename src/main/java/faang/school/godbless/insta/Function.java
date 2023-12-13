package faang.school.godbless.insta;

@FunctionalInterface
public interface Function<T, R> {
    T apply(R image);
}
