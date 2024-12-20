package school.faang.task_46305;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        String param = "Param";
        String paramZero = "0";

        ExceptionCatch<String, String, Exception> functionCall = RemoteService::call;
        Function<Exception, String> exceptionCatch = exception -> {
            warn("RemoteService недоступен");
            return "default";
        };

        System.out.println(withErrorHandling(param, functionCall, exceptionCatch));
        System.out.println(withErrorHandling(paramZero, functionCall, exceptionCatch));
    }

    public static String withErrorHandling(String param,
                                           ExceptionCatch<String, String, Exception> functionCall,
                                           Function<Exception, String> exceptionCatch) {
        try {
            return functionCall.tryCatch(param);
        } catch (Exception e) {
            return exceptionCatch.apply(e);
        }
    }

    private static void warn(String msg) {
        System.out.println("warn msg = " + msg);
    }
}

