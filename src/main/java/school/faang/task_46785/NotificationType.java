package school.faang.task_46785;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NotificationType {
    EMAIL("email"),
    SMS("sms"),
    PUSH("push");

    private final String nonificationType;

}
