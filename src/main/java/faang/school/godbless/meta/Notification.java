package faang.school.godbless.meta;

import lombok.Data;
import lombok.NonNull;

@Data
public class Notification {
    @NonNull
    private String type;
    @NonNull
    private String message;
}
