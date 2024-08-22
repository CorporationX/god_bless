package faang.school.godbless.beautiful.exception.handling;

public class RemoteService {
    public String call(String param) throws Exception {
        if (param.equals("error")) {
            throw new Exception("Service call error");
        }
        return "Result " + param;
    }
}
