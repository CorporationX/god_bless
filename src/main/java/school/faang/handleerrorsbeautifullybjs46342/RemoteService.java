package school.faang.handleerrorsbeautifullybjs46342;

import java.io.IOException;

public class RemoteService {
    public static String call(String param) throws ServiceUnavailableException {
        throw new ServiceUnavailableException("Service is unavailable");
    }
}
