package faang.school.godbless;

public class Main {

    @FunctionalInterface
    interface ExceptionHandler {
        void handleException(Exception e);
    }

    @FunctionalInterface
    interface Action<T> {
        T perform() throws Exception;
    }

    public static <T> T withErrorHandling(Action<T> action, ExceptionHandler exceptionHandler) {
        try {
            return action.perform();
        } catch (Exception e) {
            exceptionHandler.handleException(e);
            return null;
        }
    }

    public static void main(String[] args) {
        String result = withErrorHandling(
                () -> remoteServiceCall("param"),
                e -> System.err.println("Не удалось получить доступ к Remote Service. Ошибка DEFAULT")
        );

        System.out.println("Результат: " + result);
    }


    private static String remoteServiceCall(String param) throws Exception {
        throw new Exception("Ошибка");
    }
}