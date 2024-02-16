package faang.school.godbless.meta;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class Notification {
    private String type;
    private String message;
}