package faang.school.godbless.sprint2.exceptionHandling;

import java.util.Optional;

public interface ExceptionHandler<T> {

    Optional<T> handleError(Exception exception);
}
