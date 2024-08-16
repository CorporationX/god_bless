package faang.school.godbless.bjs2_21109;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T apply(Exception e);
}
