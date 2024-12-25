package school.faang.task_49873;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MasterCardService {
    public static final Logger LOGGER = LoggerFactory.getLogger(MasterCardService.class);
    private final int timeCollectPayment = 10000;
    private final int timeSendAnalytics = 1000;

    public int collectPayment() {
        try {
            Thread.sleep(timeCollectPayment);
            LOGGER.debug("Процесс оплаты успешно выполнен:");
            return timeCollectPayment;
        } catch (InterruptedException e) {
            LOGGER.error("Ошибка выполнения процесса оплаты {}", e.getMessage());
        }
        return 0;
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(timeSendAnalytics);
            LOGGER.debug("Процесс отправки аналитики успешно выполнен:");
            return timeSendAnalytics;
        } catch (InterruptedException e) {
            LOGGER.error("Ошибка выполнения процесса отправки аналитики {}", e.getMessage());
        }
        return 0;
    }
}
