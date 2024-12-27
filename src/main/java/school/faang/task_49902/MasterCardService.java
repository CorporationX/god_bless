package school.faang.task_49902;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MasterCardService {
    private static final int COLLECT_EXECUTION_TIME = 10_000;
    private static final int SEND_ANALYTIC_EXECUTION_TIME = 1_000;
    private static final int PAYMENT_AMOUNT = 1_000;

    public static int collectPayment() {
        try {
            Thread.sleep(COLLECT_EXECUTION_TIME);
            return PAYMENT_AMOUNT;
        } catch (InterruptedException e) {
            log.error("Поток {} был прерван", Thread.currentThread().getName(), e);
            Thread.currentThread().interrupt();
            return 0;
        }
    }

    public static String sendAnalytics() {
        try {
            Thread.sleep(SEND_ANALYTIC_EXECUTION_TIME);
            return "Отчет с аналитикой";
        } catch (InterruptedException e) {
            log.error("Поток {} был прерван", Thread.currentThread().getName(), e);
            Thread.currentThread().interrupt();
            return "Отчет не был сформирован";
        }
    }
}
