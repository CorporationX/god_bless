package faang.school.godbless.BJS2_25060;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Kingdom kingdom1 = new Kingdom(executor, "Sber");
        Kingdom kingdom2 = new Kingdom(executor, "Yandex");

        kingdom1.sendRaven(kingdom2).handle((result, exception) -> {
            if (result != null) {
                System.out.printf("Письмо в %s доставлено%n", result.getName());
                return result;
            } else {
                MessageNotDeliveredException deliveredException = (MessageNotDeliveredException) exception.getCause();
                System.out.printf("Письмо в %s НЕ доставлено%n", deliveredException.getKingdom().getName());
                return deliveredException;
            }
        }).join();

        executor.shutdown();
        try {
            if (!executor.awaitTermination(12, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
