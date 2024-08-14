package faang.school.godbless.handlingerrors;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandlerUtil.withErrorHandling(
                () -> {
                    try {
                        return callRemoteService("someParam");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                },
                (exception) -> {
                    logWarn("Не удалось получить доступ к Remote Service. Вернем default значение", exception);
                    return "DEFAULT";
                }
        );
        System.out.println("Результат: " + result);
    }

    private static String callRemoteService(String param) throws Exception {
        // Здесь симулируется вызов удалённого сервиса
        if ("someParam".equals(param)) {
            return "SUCCESS";
        }
        throw new Exception("Ошибка при вызове удалённого сервиса");
    }

    private static void logWarn(String message, Exception e) {
        System.out.println(message + " Причина: " + e.getMessage());
    }
}