package faang.school.godbless.Task24_Feed_Griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {

    static final String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

    public static void main(String[] args) {
            ExecutorService deliveryExecutor = Executors.newFixedThreadPool(3);
            for (String characterName : characterNames) {
                deliveryExecutor.submit(new FoodDeliveryTask(characterName, new Random().nextInt(1, 5)));
            }
            deliveryExecutor.shutdown();
    }

}
