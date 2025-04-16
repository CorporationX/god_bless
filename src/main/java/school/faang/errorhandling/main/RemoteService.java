package school.faang.errorhandling.main;

public class RemoteService {
    public static String getData() {
        throw new RuntimeException("Service unavailable");
    }
}