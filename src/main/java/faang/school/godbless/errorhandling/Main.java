package faang.school.godbless.errorhandling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> remoteServiceCall("param"),
                e -> log.warn("Не удалось получить доступ к Remote Service. Вернем default значение", e));

        System.out.println("Result: " + (result != null ? result : "DEFAULT"));
    }

    public static String remoteServiceCall(String param) {
        if ("param".equals(param)) {
            throw new RuntimeException("Remove service failed");
        }
        return "SUCCESS";
    }
}
