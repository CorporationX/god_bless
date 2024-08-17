package faang.school.godbless.lambda.metauniverse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Notification {
    @Getter
    private String id;
    private String message;
}
