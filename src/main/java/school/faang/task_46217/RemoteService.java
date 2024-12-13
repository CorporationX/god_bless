package school.faang.task_46217;

public class RemoteService {
    public static String call(String param) throws Exception {
        if (param.equals("Connect")) {
            return "Connection...";
        } else {
            throw new Exception("Failed to connect");
        }
    }
}
