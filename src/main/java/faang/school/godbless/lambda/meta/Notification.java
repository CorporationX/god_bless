package faang.school.godbless.lambda.meta;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Notification {
    private String type;
    private String message;
}
