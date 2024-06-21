package faang.school.godbless.FeedPeterGriffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static final ExecutorService THREAD_POOL = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String name : characterNames) {
            int numberOfFoodUnits = new Random().nextInt(50);
            THREAD_POOL.submit(new FoodDeliveryTask(name, numberOfFoodUnits));
        }
        THREAD_POOL.shutdown();
    }
}
