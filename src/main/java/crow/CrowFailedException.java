package crow;

import lombok.NonNull;

public class CrowFailedException extends RuntimeException {
    public CrowFailedException(@NonNull String message) {
        super(message);
    }
}
