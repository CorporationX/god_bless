package faang.school.godbless.sprint2.Handle_errors;

import java.util.function.Supplier;

public class HandleErrors {
    public static <T>  T withErrorHandling(Supplier<T> supplier,ExceptionHandler<T> errorHandling ){
        try {
            return supplier.get();
        }catch (Exception e){
            return errorHandling.exception(e);
        }
    }
}
