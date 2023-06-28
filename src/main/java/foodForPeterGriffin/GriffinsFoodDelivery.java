package foodForPeterGriffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (String name : characterNames) {
            service.submit(new FoodDeliveryTask(name, new Random().nextInt(50)));
        }
        service.shutdown();
    }
}
