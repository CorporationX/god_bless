package faang.school.godbless.BJS2_21118;

public class RemoteService {
    public String call(String param) {
        if (param.equals("error")) throw new RuntimeException("Test exception");
        return param;
    }
}
