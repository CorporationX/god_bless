package school.faang.sprint1_2.bjs2_80121;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}