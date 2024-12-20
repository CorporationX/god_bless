package school.faang.sprint_2.task_46292;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> {
                    try {
                        return RemoteService.call("someParam");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                },
                e -> {
                    System.out.println("Error calling service, returning default value");
                    return "DEFAULT";
                }
        );
        System.out.println(result);
    }
}
