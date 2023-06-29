package faang.school.godbless;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for (String characterName : characterNames) {
            var delivery = new FoodDeliveryTask(characterName, new Random().nextInt(4, 50));
            service.submit(delivery);
        }
        service.shutdown();
    }
}
