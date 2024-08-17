package faang.school.godbless.metauniverse;

import lombok.Data;
import lombok.NonNull;

@Data
public class Notification {

    @NonNull
    private final String type;

    @NonNull
    private final String message;

}
