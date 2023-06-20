package faang.school.godbless;

import lombok.Data;
import lombok.NonNull;

@Data
public class Notification {
    @NonNull
    private String type;
    @NonNull
    private String message;
}
