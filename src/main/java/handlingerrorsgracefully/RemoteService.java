package handlingerrorsgracefully;

public class RemoteService {
    public static String call(String param) {
        throw new RuntimeException("Service is not available");
    }
}
