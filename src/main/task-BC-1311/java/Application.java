import java.util.function.Supplier;

public class Application {
    public static void main(String[] args) {
        ExceptionHandler exceptionHandler = (e) -> {System.out.println(e.getMessage());
            return e;
        };

        withErrorHandling(() -> {System.out.println("Some action");
            throw new IllegalArgumentException("Error");
//            return "success";
        }, exceptionHandler);
    }

    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> exceptionHandler){
        try{
//            String success = (String) supplier.get();
//            System.out.println(success);
            return supplier.get();
        } catch (Exception e){
           return exceptionHandler.handle(e);
        }

    }
}
