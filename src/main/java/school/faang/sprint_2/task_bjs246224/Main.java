package school.faang.sprint_2.task_bjs246224;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("someParam"),
                e -> {
                    System.out.println("Connection error, return default value");
                    return "DEFAULT";
                }
        );
        System.out.println(result);
    }
}
