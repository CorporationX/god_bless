package faang.school.godbless.fi.errorhandling;

public interface ExceptionHandler<T> {

    T handle(Exception e);

}
