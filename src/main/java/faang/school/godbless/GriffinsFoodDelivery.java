package faang.school.godbless;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random random = new Random();

        for (String characterName : characterNames) {
            service.submit(new FoodDeliveryTask(characterName, random.nextInt(50) + 1));
        }
        service.shutdown();
    }
}
