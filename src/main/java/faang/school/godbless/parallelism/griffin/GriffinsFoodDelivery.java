package faang.school.godbless.parallelism.griffin;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService service = Executors.newFixedThreadPool(3);
        toFeedGriffin(characterNames, service);
    }

    private static void toFeedGriffin(String[] stringsName, ExecutorService executorService) {
        Arrays.stream(stringsName)
                .forEach(a ->
                        executorService.submit(() -> new FoodDeliveryTask(a, new Random().nextInt(1, 51)).run()));
        executorService.shutdown();
    }
}
