package faang.school.godbless.BJS2_3137;


import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Arrays.stream(characterNames).forEach((characterName) -> executorService.submit(new FoodDeliveryTask(characterName, new Random().nextInt(20) + 1)));
        executorService.shutdown();
    }
}
