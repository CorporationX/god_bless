package school.faang.task_51580;

import lombok.extern.slf4j.Slf4j;

import java.text.DecimalFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        Organization organization = new Organization();
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        log.info("Starting donation process...");
        for (int i = 1; i < 10; i++) {
            double amount = Math.random() * 100;
            int id = i;
            double roundedAmount = Math.floor(amount * 100) / 100;
            log.info("Запрос на донат от ID: {}, сумма пожертвования: {} $", id, decimalFormat.format(roundedAmount));

            executorService.submit(() -> {
                Donation donation = new Donation(id, roundedAmount);
                organization.addDonation(donation);
                log.info("Обработанное пожертвование: ID: {}, сумма пожертвования: {} $",
                        donation.getId(), decimalFormat.format(donation.getAmount()));
            });
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                log.error("Программа не завершилась за отведенное время");
            } else {
                log.info("Программа завершилась успешно");
            }
        } catch (InterruptedException e) {
            log.error("Программа прервана с ошибкой: {}", e.getMessage());
            Thread.currentThread().interrupt();
        }
        log.info("Финальный баланс: {} $", decimalFormat.format(organization.getBalance()));
        organization.donationsReport();
    }
}
