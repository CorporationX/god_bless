package ErrorHandler;

public class RemoteService {
    public static String call(String param) throws Exception {
        throw new Exception("Service does not exist");
    }
}
