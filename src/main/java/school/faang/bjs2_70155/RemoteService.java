package school.faang.bjs2_70155;

public class RemoteService {
    public static String call(String param) {
        if (param.equals("someParam")) {
            throw new RuntimeException("Service unavailable");
        }
        return param;
    }
}
