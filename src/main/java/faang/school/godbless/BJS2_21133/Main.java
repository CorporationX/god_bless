package faang.school.godbless.BJS2_21133;

public class Main {

    private static String performRiskyOperation(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value must be non-negative");
        }
        return "Operation successful with value: " + value;
    }

    public static void main(String[] args) {
        String result1 = ErrorHandle.withErrorHandling(
                () -> performRiskyOperation(-1), Throwable::getMessage);
        System.out.println("Result: " + result1);
    }
}
