package sprint4.griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            service.execute(new FoodDeliveryTask(characterNames[random.nextInt(5)], random.nextInt(50)));
        }
        service.shutdown();
    }
}
