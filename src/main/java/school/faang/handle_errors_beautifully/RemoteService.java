package school.faang.handle_errors_beautifully;

import java.util.Objects;

public class RemoteService {
    public static final String NULL_PARAM_ERROR = "Param cannot be null";
    public static final String BLANK_PARAM_ERROR = "Param cannot be blank";

    public static String call(String param) {
        Objects.requireNonNull(param, NULL_PARAM_ERROR);
        if (!param.isBlank()) {
            throw new RuntimeException("Service is unavailable"); //some test code with generate error
        }
        throw new IllegalArgumentException(BLANK_PARAM_ERROR);
    }
}
