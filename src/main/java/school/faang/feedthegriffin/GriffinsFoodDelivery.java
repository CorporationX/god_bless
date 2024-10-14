package school.faang.feedthegriffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        String[] charactersName = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for (String name : charactersName) {
            service.submit(new FoodDeliveryTask(name, new Random().nextInt(100)));
        }
        service.shutdown();
    }
}
