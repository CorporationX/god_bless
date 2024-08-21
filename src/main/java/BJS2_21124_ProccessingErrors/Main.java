package BJS2_21124_ProccessingErrors;

public class Main {
    public static void main(String[] args) {
        ErrorHandler.withErrorHandling(() -> {
            try {
                return validateString("parameter");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, exception -> {
            System.out.println("Error! Invalid parameter!");
            return exception;
        });
    }

    public static String validateString(String parameter) {
        if (parameter.equals("parameter")) {
            System.out.println(parameter);
            return parameter;
        }
        throw new RuntimeException("Error!");
    }
}
