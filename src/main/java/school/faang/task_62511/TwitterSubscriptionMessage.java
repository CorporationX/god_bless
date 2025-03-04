package school.faang.task_62511;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TwitterSubscriptionMessage {
    START_ACCOUNT_FOLLOW("Процесс подписки на аккаунт \"{}\" запущен."),
    END_ACCOUNT_FOLLOW("Процесс подписки на аккаунт \"{}\" завершен."),
    TERMINATION_AWAIT_EXCEPTION("Не все задачи выполнились за отведённое время!"),
    INTERRUPT_EXCEPTION("Ожидание завершения задач прервано");

    private final String message;
}
