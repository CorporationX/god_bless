import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String character : characterNames) {
            FoodDeliveryTask foodDeliveryTask = new FoodDeliveryTask(character, new Random().nextInt(100));
            executor.submit(foodDeliveryTask);
        }

        executor.shutdown();
    }
}
