package school.faang.feedthegriffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        try {
            ExecutorService service = Executors.newFixedThreadPool(3);
            String[] charactersName = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
            for (String name : charactersName) {
                service.submit(new FoodDeliveryTask(name, new Random().nextInt(100)));
            }
            service.awaitTermination(5, TimeUnit.SECONDS);
            service.shutdown();
        } catch (InterruptedException e) {
            throw new IllegalStateException("Прервался метод main, в классе GriffinsFoodDelivery", e);
        }
    }
}
