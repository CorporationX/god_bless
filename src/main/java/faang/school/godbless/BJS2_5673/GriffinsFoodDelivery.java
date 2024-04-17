package faang.school.godbless.BJS2_5673;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random amount = new Random();

        for (String character : characterNames) {
            service.execute(new FoodDeliveryTask(character, amount.nextInt(100), amount.nextInt(5)));
        }
        service.shutdown();
    }
}
