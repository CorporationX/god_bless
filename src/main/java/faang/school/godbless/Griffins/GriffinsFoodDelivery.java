package faang.school.godbless.Griffins;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random random = new Random();
        for (String character : characterNames) {
            pool.execute(new FoodDeliveryTask(character, random.nextInt(70)));
        }
        pool.shutdown();
    }
}
