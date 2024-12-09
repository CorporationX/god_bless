package school.faang.sprint_2.task_46410;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(() -> call("store"),
                e -> {
                    System.out.println("Error calling service, returning default value.");
                    return "default";
                });

        System.out.println(result);

        String exception = ErrorHandler.withErrorHandling(() -> call("exception"),
                e -> {
                    System.out.println("Error calling service, returning default value.");
                    return "default";
                });

        System.out.println(exception);
    }

    public static String call(String param) throws Exception {
        if ("exception".equals(param)) {
            throw new Exception("Service unavailable");
        } else {
            return param;
        }
    }
}
