package faang.school.godbless.bjs2_5025;

@FunctionalInterface
public interface ExceptionHandler<T> {

    T handle(Exception exception);
}
