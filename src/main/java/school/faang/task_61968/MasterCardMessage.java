package school.faang.task_61968;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MasterCardMessage {
    COLLECT_PAYMENT("\"Получение платежа\""),
    SEND_ANALYTICS("\"Отправка аналитики\""),
    PROCESS_START_MESSAGE("Процесс {} запущен"),
    INTERRUPT_SLEEP_MESSAGE("Ожидание потока \"{}\" прервано"),
    ANALYTICS_RESULT_MESSAGE("Аналитика отправлена: {}"),
    PAYMENT_RESULT_MESSAGE("Платеж выполнен: {}");

    private final String message;
}
