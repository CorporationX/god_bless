package Exeption;

import java.util.function.Supplier;

public class ErrorHandler {
    static<T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> exceptionHandler){
        try{
            return supplier.get();
        } catch (Exception e){
            return exceptionHandler.handle(e);
        }
    }
}
