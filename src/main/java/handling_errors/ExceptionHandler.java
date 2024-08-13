package handling_errors;
@FunctionalInterface
public interface ExceptionHandler<T> {
     T handle(Exception e);
}
