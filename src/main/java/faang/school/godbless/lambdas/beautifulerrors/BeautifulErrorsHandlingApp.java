package faang.school.godbless.lambdas.beautifulerrors;

import java.util.function.Function;

public class BeautifulErrorsHandlingApp {

    public static void main(String[] args) {
        RemoteService remoteService = new RemoteService();
        String availableParam = "Param";
        String paramZero = "0";

        ThrowableFunction<String, String, Exception> functionCall = remoteService::call;
        Function<Exception, String> exceptionHandler = exception -> {
            warn("Не удалось получить доступ к Remote Service. Вернем default значение");
            return "DEFAULT";
        };

        System.out.println(withErrorHandling(availableParam, functionCall, exceptionHandler));
        System.out.println(withErrorHandling(paramZero, functionCall, exceptionHandler));

    }

    public static String withErrorHandling(String param, ThrowableFunction<String, String, Exception> functionCall, Function<Exception, String> exceptionHandler) {
        try {
            return functionCall.apply(param);
        } catch (Exception e) {
            return exceptionHandler.apply(e);
        }
    }

    private static void warn(String msg) {
        System.out.println("warn msg = " + msg);
    }

}

