package school.faang.BJS2_61361;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < characterNames.length; i++) {
            service.execute(new FoodDeliveryTask(characterNames[i], 10));
        }

    }
}