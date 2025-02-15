package BJS257630;

@FunctionalInterface
public interface ExceptionHandler<T> {
    String problemMessage = " We have any problem ";

    T handle(Exception e);
}
