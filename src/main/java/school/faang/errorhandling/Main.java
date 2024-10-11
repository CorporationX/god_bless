package school.faang.errorhandling;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        // Example with calling a remote service
        RemoteService remoteService = new RemoteService();
        String availableParam = "Param";
        String paramZero = "0";

        ThrowableFunction<String, String, Exception> functionCall = remoteService::call;
        Function<Exception, String> exceptionHandler = exception -> {
            System.out.println("Don't allowed remote service. It will return default");
            return "DEFAULT";
        };

        System.out.println(withErrorHandling(availableParam, functionCall, exceptionHandler));
        System.out.println(withErrorHandling(paramZero, functionCall, exceptionHandler));

    }
        // Example of a method for a remote service
    public static class RemoteService {
        public String call(String param) throws Exception {
        // An error will be thrown here for demonstration
            throw new Exception("Service unavailable");
        }
    }

    public static String withErrorHandling(String param,
                                           ThrowableFunction<String, String, Exception> functionCall,
                                           Function<Exception, String> errorHandling) {
        try {
            return functionCall.apply(param);
        } catch (Exception e) {
            return errorHandling.apply(e);
        }
    }
}


