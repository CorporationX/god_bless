package faang.school.godbless.lambda.task9exeptions;

import lombok.Data;

@FunctionalInterface
public interface ExceptionHandler {
    void handleException(Exception e);
}
