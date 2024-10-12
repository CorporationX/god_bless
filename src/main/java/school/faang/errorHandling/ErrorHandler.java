package school.faang.errorHandling;


public class ErrorHandler {
    public static <T> T withErrorHandling(MainActionI<T> main, ErrorActionI<T> error){
        try {
            return main.get();
        }catch (Exception e){
          return  error.handleError(e);
        }
    }
}