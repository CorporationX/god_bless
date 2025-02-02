package school.faang.bjs246318;

public class Main {
    public static void main(String[] args) {
        String requestOnRemoteService =
                ErrorHandler.withErrorHandling(() -> RemoteService.calls("Very important parameters"),
                        e -> {
                            System.out.println(e.getMessage());
                            return "Default answer";
                        });
        System.out.println(requestOnRemoteService);
    }
}
