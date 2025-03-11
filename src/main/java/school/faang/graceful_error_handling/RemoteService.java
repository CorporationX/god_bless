package school.faang.graceful_error_handling;

public class RemoteService {
    public static String call(String someParameter) throws Exception {
        System.out.println("Trying to call service with parameter " + someParameter);
        throw new Exception("This is runtime exception");
    }
}
