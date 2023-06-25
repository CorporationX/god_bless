package faang.school.godbless.thirdSprint.FeedPeterGriffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        Random random = new Random();
        ExecutorService service = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String characterName : characterNames) {
            int foodAmount = random.nextInt(50);
            service.execute(new FoodDeliveryTask(characterName, foodAmount));
        }
        service.shutdown();
    }
}
