package faang.school.godbless.errors;

import java.util.function.Supplier;

//R - возвращаемый  тип при нормальной работе программе и тип дефолтного значения,
//возвращаемого при возникновении исключения
public class Handling<R> {
    public R withErrorHandling(Supplier<R> supplier, ExceptionHandler<R> exceptionHandler) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return exceptionHandler.hand(e);
        }
    }
}
