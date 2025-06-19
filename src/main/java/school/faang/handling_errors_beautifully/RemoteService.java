package school.faang.handling_errors_beautifully;

public class RemoteService {
    public static String call(String param) {
        throw new RuntimeException(param);
    }
}