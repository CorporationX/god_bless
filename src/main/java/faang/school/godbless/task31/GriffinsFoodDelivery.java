package faang.school.godbless.task31;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executorService = Executors.newFixedThreadPool(characterNames.length);
        Random random = new Random();
        for (String characterName : characterNames) {

            executorService.submit(new FoodDeliveryTask(characterName,random.nextInt(100)));
        }
    }
}
