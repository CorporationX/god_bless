package petter.griffin;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static final int MAX_FOOD_COUNT = 15;

    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random rand = new Random();
        try (ExecutorService executor = Executors.newFixedThreadPool(3)) {
            Arrays.stream(characterNames).forEach(
                    character -> executor.submit(new FoodDeliveryTask(character, rand.nextInt(MAX_FOOD_COUNT))));
        }
    }
}
