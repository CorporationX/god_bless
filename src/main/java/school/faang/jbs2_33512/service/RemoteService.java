package school.faang.jbs2_33512.service;

import lombok.NonNull;

public class RemoteService {
    public static String call(@NonNull String param) throws Exception {
        if (param.isEmpty()) {
            throw new IllegalArgumentException("The service is unavailable");
        }
        return "call completed";
    }
}
