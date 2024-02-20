package faang.school.godbless.lambda.handing_exception;

import java.util.NoSuchElementException;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        withErrorHandling(() -> remoteService(), e -> handleServiceException(e));

        System.out.println("-------------------------------------------");

        System.out.println(withErrorHandling(() -> exceptionRemoteService(), e -> handleServiceException(e)));
    }

    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> errorHandling){
        try{
            return action.get();
        } catch (Exception e){
            return errorHandling.handle(e);
        }
    }

    public static int remoteService() {
        System.out.println("Вызываю Remote Service...");
        System.out.println("Готово");
        return 1;
    }

    public static int exceptionRemoteService(){
        throw new NoSuchElementException("Error");
    }

    public static String handleServiceException(Exception e){
        System.out.println("Error " + e.getClass().getName());
        return "DEFAULT";
    }
}
