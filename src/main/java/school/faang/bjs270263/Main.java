package school.faang.bjs270263;

public class Main {
    public static void main(String[] args) {
        RemoteService remoteService = new RemoteService();
        String result = ErrorHandler.invoke(
                () -> remoteService.call("someParam"),
                e -> {
                    System.out.println("Error while calling a service, return a default value");
                    return "DEFAULT";
                }
        );

        System.out.println(result);
    }

    public static class RemoteService {
        public String call(String param) {
            throw new IllegalStateException("Service unavailable");
        }
    }
}
