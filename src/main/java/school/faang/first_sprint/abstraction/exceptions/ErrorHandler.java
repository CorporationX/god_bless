package school.faang.first_sprint.abstraction.exceptions;

public interface ErrorHandler<T> {
    T handle(Exception e);
}
