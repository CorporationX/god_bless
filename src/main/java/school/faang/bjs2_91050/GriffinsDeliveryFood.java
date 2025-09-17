package school.faang.bjs2_91050;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsDeliveryFood {
    public static void main(String[] args) {
        ExecutorService deliveryCars = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewart"};

        for (String character : characterNames) {
            deliveryCars.execute(new FoodDeliveryTask(character));
        }

        deliveryCars.shutdown();

        try {
            if (!deliveryCars.awaitTermination(20, TimeUnit.SECONDS)) {
                System.out.println("Машины слишком задерживаются, что-то пошло не так. Отменяем доставку!");
                deliveryCars.shutdownNow();
            } else {
                System.out.println("Оператор: Гриффины получили свои заказы!");
            }
        } catch (InterruptedException e) {
            System.out.println("Работа оператора была прервана!");
            Thread.currentThread().interrupt();
        }
    }
}