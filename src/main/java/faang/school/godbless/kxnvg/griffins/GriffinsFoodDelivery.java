package faang.school.godbless.kxnvg.griffins;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (int i = 0; i < characterNames.length; i++) {
            service.execute(new FoodDeliveryTask(characterNames[i], new Random().nextInt(100)));
        }

        service.shutdown();
    }
}
