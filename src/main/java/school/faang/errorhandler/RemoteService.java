package school.faang.errorhandler;

public class RemoteService {

    public String call(String param) {
        throw new IllegalStateException("Service unavailable");
    }
}

