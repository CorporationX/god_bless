package school.faang.bjs248587;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {

    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (String character : characterNames) {
            GoodDeliveryTask deliveryTask =
                    new GoodDeliveryTask(character, new Random().nextInt(20) + 1);
            executor.submit(deliveryTask);
        }
        executor.shutdown();
    }

}
