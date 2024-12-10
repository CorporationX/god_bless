package school.faang.sprint2.task_46163;

public class Main {
    public static void main(String[] args) {
        RemoteService remoteService = new RemoteService();

        String result = RemoteConnection.withErrorHandling(() -> remoteService.call("someparam"), (e) -> {
            System.out.println(e.getMessage());
            return "No connection";
        });
        System.out.println(result);
    }
}
