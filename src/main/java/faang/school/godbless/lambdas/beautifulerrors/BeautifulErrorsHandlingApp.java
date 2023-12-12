package faang.school.godbless.lambdas.beautifulerrors;

public class BeautifulErrorsHandlingApp {

    public static void main(String[] args) {
        RemoteService remoteService = new RemoteService();
        String availableParam = "Param";
        String paramZero = "0";

        ThrowableFunction<String, String, Exception> functionCall = remoteService::call;
        ExceptionHandler<Exception, String> exceptionHandler = exception -> {
            warn("Не удалось получить доступ к Remote Service. Вернем default значение");
            return "DEFAULT";
        };

        System.out.println(withErrorHandling(availableParam, functionCall, exceptionHandler));
        System.out.println(withErrorHandling(paramZero, functionCall, exceptionHandler));

    }

    public static String withErrorHandling(String param, ThrowableFunction<String, String, Exception> functionCall, ExceptionHandler<Exception, String> exceptionHandler) {
        try {
            return functionCall.apply(param);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    private static void warn(String msg) {
        System.out.println("warn msg = " + msg);
    }

}

