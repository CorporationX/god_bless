package faang.school.godbless.sprint2.exceptionHandling;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
            TestService testService = new TestService();

            Optional<String> optionalWithoutException = ExceptionUtils.withErrorHandling(testService::getResultWithoutException, (exception) -> {
                System.out.println("error message: " + exception.getMessage());
                return Optional.empty();
            });

            Optional<String> optionalWithException = ExceptionUtils.withErrorHandling(testService::getResultWithException, (exception) -> {
                System.out.println("error message: " + exception.getMessage());
                return Optional.empty();
            });
    }
}
