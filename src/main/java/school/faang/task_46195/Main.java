package school.faang.task_46195;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("someParam"),
                exception -> {
                    System.out.println("Error occurred: " + exception.getMessage());
                    return "DEFAULT";
                }
        );

        System.out.println(result);
    }
}