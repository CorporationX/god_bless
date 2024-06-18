package faang.school.godbless.Griffin;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;


public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String characterName : characterNames) {
            int foodAmount = new Random().nextInt(100) + 1;
            executor.submit(new FoodDeliveryTask(characterName, foodAmount));
        }

        executor.shutdown();
    }
}
