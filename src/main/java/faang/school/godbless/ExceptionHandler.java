package faang.school.godbless;
@FunctionalInterface
public interface  ExceptionHandler<T> {
    public T onException(Exception e);
}
