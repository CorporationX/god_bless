package school.faang.bjs2_70675;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum NotificationType {
    EMAIL("Электронная почта"),
    SMS("SMS-сообщение"),
    PUSH("PUSH-уведомление"),
    TELEGRAM("Сообщение в телегу");

    private final String title;
}
