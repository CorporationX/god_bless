package faang.school.godbless.metaUniverse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Notification {
    private String type;
    private String message;
}