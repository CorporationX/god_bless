package feed_peter_griffin;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static int randomNum = new Random().nextInt(10);
    public static void main(String[] args) {

        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Arrays.stream(characterNames).forEach((character)-> executorService.submit(new FoodDeliveryTask(character,randomNum)));
        executorService.shutdown();
    }
}