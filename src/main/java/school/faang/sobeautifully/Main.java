package school.faang.sobeautifully;

public class Main {
    public static void main(String[] args) {
        String result1 = ErrorHandling.withErrorHandling(
                () -> Service.call1("param"),
                e -> {
                    System.out.println("Тут ошибка вызвалась");
                    return "Default";
                });
        String result2 = ErrorHandling.withErrorHandling(
                () -> Service.call2("param"),
                e -> {
                    System.out.println("Тут ошибка вызвалась");
                    return "Default";
                });
        System.out.println("Первый вызов: " + result1 + "\nВторой вызов: " + result2);
    }

    public static class Service {
        public static String call1(String param) {
            throw new RuntimeException("Сервис недоступен");
        }

        public static String call2(String param) {
            return param + " new string";
        }
    }
}
