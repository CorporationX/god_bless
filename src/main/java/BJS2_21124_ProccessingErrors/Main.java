package BJS2_21124_ProccessingErrors;

public class Main {
    public static void main(String[] args) {
        ErrorHandler.withErrorHandling(() -> {
            try {
                return returnSomething("parameter");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, exception -> {
            System.out.println("Error! Invalid parameter!");
            return exception;
        });
    }

    //Mock class for test errorHandler
    public static String returnSomething(String s) throws Exception {
        if (s.equals("parameter")) {
            return s;
        }
        throw new Exception("Error!");
    }
}
