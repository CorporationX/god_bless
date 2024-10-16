package school.BJS2_35966;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {

    private static final int NUMBER_OF_THREADS = 3;

    public static void main(String[] args) {

        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        for (int i = 0; i < characterNames.length; i++) {
            int foodNumber = new Random().nextInt(50);
            fixedThreadPool.execute(new FoodDeliveryTask(characterNames[i], foodNumber));
        }
        fixedThreadPool.shutdown();


    }
}
