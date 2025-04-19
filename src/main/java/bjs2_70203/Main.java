package bjs2_70203;

import java.time.LocalDateTime;
import java.time.Period;

public class Main {
    private static final LocalDateTime NOW = LocalDateTime.now();

    public static void main(String[] args) {
        LocalDateTime age = LocalDateTime.of(2004, 12, 28, 1, 32);
        String result = ErrorProcessor.withErrorHandling(
                () -> AgeHandler.handler(age),
                e -> {
                    System.out.println("An error occurred when the application was running! Returning the default value");
                    return "DEFAULT";
                }
        );

        System.out.println(result);
    }

    public static class AgeHandler<T> {

        public static String handler(LocalDateTime dateOfBirth) {
            Period period = Period.between(dateOfBirth.toLocalDate(), NOW.toLocalDate());
            if (period.getYears() >= 18 && period.getYears() < 130) {
                return "The correct date has been entered.";
            } else {
                throw new IllegalArgumentException("You must be over 18 years old and under 130!");
            }
        }
    }
}
