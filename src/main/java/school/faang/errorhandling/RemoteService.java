package school.faang.errorhandling;

public class RemoteService {
    public static String call(String param) {
        if (param.contains("error")) {
            throw new RuntimeException("catch me!");
        }
        return "COMPLETED";
    }
}
