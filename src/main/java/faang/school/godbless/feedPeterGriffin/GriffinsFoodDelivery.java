package faang.school.godbless.feedPeterGriffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (String character : characterNames) {
            int foodAmount = new Random().nextInt(51);
            FoodDeliveryTask deliveryTask = new FoodDeliveryTask(character, foodAmount);
            executorService.submit(deliveryTask);
        }
        executorService.shutdown();
        System.out.println("Griffin's heroes is fed");
    }
}
