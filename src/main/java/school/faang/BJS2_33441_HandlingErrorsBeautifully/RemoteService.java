package school.faang.BJS2_33441_HandlingErrorsBeautifully;

public class RemoteService {
    public static String call(String param) throws Exception {
        throw new Exception("Service is unavailable!");
    }
}
