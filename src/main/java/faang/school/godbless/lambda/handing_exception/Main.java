package faang.school.godbless.lambda.handing_exception;

import java.util.NoSuchElementException;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        withErrorHandling(() -> remoteService(), e -> {
            System.out.println("Error " + e.getClass().getName());
            return "DEFAULT";
        });

        System.out.println("-------------------------------------------");

        withErrorHandling(() -> exceptionRemoveService(), e -> {
            System.out.println("Error " + e.getClass().getName());
            return "DEFAULT";
        });
    }

    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> errorHandling){
        try{
            return action.get();
        } catch (Exception e){
            return errorHandling.handler(e);
        }
    }

    public static int remoteService() {
        System.out.println("Вызываю Remote Service...");
        System.out.println("Готово");
        return 1;
    }

    public static int exceptionRemoveService(){
        throw new NoSuchElementException("Error");
    }
}
