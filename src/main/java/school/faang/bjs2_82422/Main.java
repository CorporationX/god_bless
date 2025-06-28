package school.faang.bjs2_82422;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            masterCardService.runPaymentAndAnalytics(executor);
        } catch (RuntimeException e) {
            log.error("ошибка при выполнении задач оплаты и аналитики", e);
        }
    }
}
