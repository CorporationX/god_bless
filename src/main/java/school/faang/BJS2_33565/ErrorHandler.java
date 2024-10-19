package school.faang.BJS2_33565;

public class ErrorHandler {
    public static String withErrorHandling(MainAction mainAction, ErrorCatcher<String> errorCatcher){
        try{
            mainAction.execute();
        }
        catch(Exception e){
            errorCatcher.catchError(e);
            System.out.println("error catch in ErrorHandler ");
        }
        return "Error";
    }
}
