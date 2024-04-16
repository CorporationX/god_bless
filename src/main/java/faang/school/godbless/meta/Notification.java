package faang.school.godbless.meta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class Notification {
    @NonNull
    private String type;
    @NonNull
    private String message;
}
