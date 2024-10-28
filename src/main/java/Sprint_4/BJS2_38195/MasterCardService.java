package Sprint_4.BJS2_38195;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class MasterCardService {

    public CompletableFuture<String> collectPayment() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Начало обработки оплаты...");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Оплата Успешно обработана.");
                return "Оплата завершена";
            } catch (InterruptedException e) {
                System.err.println("Процесс оплаты был прерван.");
                return "Ошибка оплаты";
            }
        });
    }


    public CompletableFuture<String> sendAnalytics() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Отправка аналитики...");
                TimeUnit.SECONDS.sleep(1); // Задержка на 1 секунду
                System.out.println("Аналитика успешно отправлена.");
                return "Аналитика отправлена";
            } catch (InterruptedException e) {
                System.err.println("Отправка аналитики была прервана.");
                return "Ошибка отправки аналитики";
            }
        });
    }

    public static void main(String[] args) {
        MasterCardService service = new MasterCardService();

        CompletableFuture<String> paymentResultFuture = service.collectPayment();
        CompletableFuture<String> analyticResultFuture = service.sendAnalytics();

        paymentResultFuture.thenAccept(paymentResult ->
                System.out.println("Результат оплаты : " + paymentResult)
        );
        analyticResultFuture.thenAccept(sendAnalytics ->
                System.out.println("Результат аналитики : " + sendAnalytics)
        );
        CompletableFuture.allOf(paymentResultFuture, analyticResultFuture).join();

        System.out.println("Все операции выполнены!");



    }

}