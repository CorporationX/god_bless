package faang.school.godbless.handling_errors;

import lombok.NonNull;

import java.util.Random;
import java.util.function.Supplier;

public class ErrorHandlingService {

    public static <T> T withErrorHandling(@NonNull Supplier<T> action, @NonNull ExceptionHandler<T> onError) {
        T object;
        try {
            object = action.get();
        } catch (Exception e) {
            object = onError.handle(e);
        }
        return object;
    }

    public static void main(String[] args) {
        int[] numbers = {4, -1, 3, 6, -55, 124, -3, -1};
        Random random = new Random();


        Supplier<Integer> action = () -> {
            int getNumber = numbers[random.nextInt(numbers.length - 1)];
            if (getNumber < 0) {
                throw new RuntimeException("Number is negative");
            }
            return getNumber;
        };

        int res = ErrorHandlingService.withErrorHandling(action, (e) -> 0);
        System.out.println(res);
    }
}
