package school.faang.BJS2_33441_HandlingErrorsBeautifully;

public class Main {
    public static void main(String[] args) {
        ThrowableAction<String, Exception> serviceCallingFunction = () -> RemoteService.call("someParam");
        ExceptionHandler<String> exceptionHandler = exception -> {
            System.out.printf("Error occurred when calling the service! %s\n", exception.getMessage());
            return "Unlucko malucko";
        };
        String serviceCallResult = ErrorHandler.withErrorHandling(serviceCallingFunction, exceptionHandler);
        System.out.println(serviceCallResult);
    }
}
