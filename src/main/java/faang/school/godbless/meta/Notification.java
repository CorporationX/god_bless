package faang.school.godbless.meta;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Notification {
    private final String type;
    private String message;
}
