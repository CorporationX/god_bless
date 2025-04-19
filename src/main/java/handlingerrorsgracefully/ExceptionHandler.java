package handlingerrorsgracefully;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
