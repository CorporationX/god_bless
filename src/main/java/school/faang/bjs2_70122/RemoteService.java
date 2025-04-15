package school.faang.bjs2_70122;

public class RemoteService {

    public static String call(String param) {
        if (param.equals("NORMAL")) {
            return "NORMAL";
        } else {
            throw new RuntimeException("The service is unavailable");
        }
    }
}
