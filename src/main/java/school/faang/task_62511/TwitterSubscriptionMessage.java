package school.faang.task_62511;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TwitterSubscriptionMessage {
    START_ACCOUNT_FOLLOW("Процесс подписки на аккаунт \"{}\" запущен."),
    END_ACCOUNT_FOLLOW("Процесс подписки на аккаунт \"{}\" завершен.");

    private final String message;
}
