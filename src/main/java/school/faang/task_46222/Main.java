package school.faang.task_46222;

public class Main {
    public static String PARAM = "Правильные параметры важны";

    public static void main(String[] args) {
        System.out.println("Вызов со строкой: '" + PARAM + "'");
        System.out.println("результат: " + checkErrorHandler(PARAM));
        System.out.println("Вызов с пустой строкой");
        System.out.println("результат: " + checkErrorHandler(""));
        System.out.println("Вызов с null");
        System.out.println("результат: " + checkErrorHandler(null));
    }

    private static String checkErrorHandler(String param) {
        return ErrorHandler.withErrorHandling(
                (v) -> RemoteService.call(param),
                e -> {
                    System.out.println("Exception при вызове сервиса: " + e.getMessage());
                    System.out.println("Возвращаем дефолтное значение");
                    return "DEFAULT";
                },
                param);
    }
}
