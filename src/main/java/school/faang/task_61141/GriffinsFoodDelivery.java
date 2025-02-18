package school.faang.task_61141;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static final int THREADS_COUNT = 3;

    public static void main(String[] args) {
        Random random = new Random();
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);
        Arrays.stream(characterNames)
                .forEach(name -> executor.execute(new FoodDeliveryTask(name, random.nextInt(0, 100))));
        executor.close();

    }
}
