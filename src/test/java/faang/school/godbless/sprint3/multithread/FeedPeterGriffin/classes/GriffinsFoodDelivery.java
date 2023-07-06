package faang.school.godbless.sprint3.multithread.FeedPeterGriffin.classes;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    private final static String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
    private final static ExecutorService service = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            String character = characterNames[new Random().nextInt(characterNames.length)];
            int foodAmount = new Random().nextInt(1, 1000);
            service.submit(new FoodDeliveryTask(character, foodAmount));
        }
        service.shutdown();
    }
}
