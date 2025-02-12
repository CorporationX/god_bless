package school.faang.handle_errors_beautifully;

public class RemoteService {
    public static String call(String param) {
        throw new RuntimeException("Service is unavailable");
    }
}
