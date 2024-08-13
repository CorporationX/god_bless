package faang.school.godbless;

public class Application {
    public static void main(String[] args) {
        String result = RemoteServiceHandler.withErrorHandling(
                () -> {
                    try {
                        return remoteServiceCall();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                },
                e -> {
                    System.out.println("The Remote Service could not be accessed. Let's return the default value.");
                    return "DEFAULT";
                }
        );
        System.out.println(result);
    }

    public static String remoteServiceCall() throws Exception {
        throw new Exception("Error");
    }
}
