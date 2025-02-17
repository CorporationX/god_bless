package school.faang.error;

public class RemoteService {
    public static String call() {
        throw new RuntimeException("The server is unavailable");
    }
}
