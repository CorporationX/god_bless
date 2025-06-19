package school.faang.bjs2_80460;

@FunctionalInterface
public interface ExceptionHandler <T> {
    T handle(Exception e);
}
