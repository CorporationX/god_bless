package feedPeterGriffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] characterNames = new String[]{"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random random = new Random();

        for (String character : characterNames) {
            executorService.submit(new FoodDeliveryTask(character, random.nextInt(10) + 1));
        }
        executorService.shutdown();
    }
}
