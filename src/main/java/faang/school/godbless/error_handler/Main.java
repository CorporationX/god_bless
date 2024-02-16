package faang.school.godbless.error_handler;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Supplier<String> caller1 = ()->askService( 1 );
        Supplier<String> caller2 = ()->askService( 2 );

        ExceptionHandler<String> exceptionHandler = exception -> {
            System.out.println("Не удалось получить доступ к Remote Service. Вернем default значение");
            return "DEFAULT";};

        withErrorHandling( caller1, exceptionHandler );
        withErrorHandling( caller2, exceptionHandler );
    }

    public static <T> void withErrorHandling(Supplier<T> call, ExceptionHandler<T> exceptionHandler){
        try {
            call.get();
        } catch (Exception ex) {
            exceptionHandler.handle( ex );
        }
    }
    public static String askService(int val){
        if(val==1){
            throw new ArithmeticException();
        }else{
            System.out.println("No errors");
            return  "OK";
        }
    }
}
