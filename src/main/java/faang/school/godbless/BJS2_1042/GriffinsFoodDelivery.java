package faang.school.godbless.BJS2_1042;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.random.RandomGenerator;

public class GriffinsFoodDelivery {


    public static void main(String[] args) {
        Random random = new Random();
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < characterNames.length; i++) {
            executor.submit(new FoodDeliveryTask(characterNames[i], RandomGenerator.getDefault().nextInt(1, 100)));
        }
        executor.shutdown();
    }

}
