package Sprint_3_Task11;
@FunctionalInterface
public interface ExceptionHandler<T> {
        T handle(Exception e);
}
