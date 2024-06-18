package faang.school.godbless.griffins;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private static final String[] CHARACTERS_NAMES = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
    private static final int THREAD_POOL_SIZE = 3;
    private static final int MAX_COUNT_FOOD = 20;
    private static final int MIN_COUNT_FOOD = 1;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (String character : CHARACTERS_NAMES) {
            executor.submit(new FoodDeliveryTask(character, randomCountFood(MIN_COUNT_FOOD, MAX_COUNT_FOOD)));
        }
        executor.shutdown();
    }

    private static int randomCountFood(int minNum, int maxNum) {
        return (int) (Math.random() * maxNum) + minNum;
    }
}
