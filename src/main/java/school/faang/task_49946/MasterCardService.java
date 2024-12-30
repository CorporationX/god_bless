package school.faang.task_49946;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MasterCardService {
    public static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            log.error("Ошибка отправки платежа", e);
            throw new RuntimeException();
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            log.error("Ошибка отправки аналитики", e);
            throw new RuntimeException();
        }
    }

}
