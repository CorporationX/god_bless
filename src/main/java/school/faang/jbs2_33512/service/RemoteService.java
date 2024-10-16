package school.faang.jbs2_33512.service;

import lombok.NonNull;

public class RemoteService {
    public String call(@NonNull String param) {
        if (param.isEmpty()) {
            throw new IllegalArgumentException("The service is unavailable");
        }
        return "call completed";
    }
}
