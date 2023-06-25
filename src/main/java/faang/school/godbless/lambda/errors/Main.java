package faang.school.godbless.lambda.errors;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandling.withErrorHandling(() -> "Успешная отправка",
                exception -> "Отпрвка не удалась" + exception);
        System.out.println(result);

        int result1 = ErrorHandling.withErrorHandling(() -> 5 / 0,
                exception -> -1);
        System.out.println(result1);
    }
}
