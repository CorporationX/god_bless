package school.faang.bjs2_34844.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TypeNotification {
    EMAIL("Sending by email: "),
    SMS("Sending SMS: "),
    PUSH("Отправка push-уведомления: ");

    private final String actionMessage;
}
