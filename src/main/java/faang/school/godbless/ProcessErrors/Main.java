package faang.school.godbless.ProcessErrors;

public class Main {
    public static void main(String[] args) {
        String normal = Processor.withErrorHandling(() -> 123354, Throwable::getMessage).toString();
        System.out.println(normal);

        String exception = Processor.withErrorHandling(() -> Integer.valueOf(null), Throwable::getMessage).toString();
        System.out.println(exception);
    }
}
