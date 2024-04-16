package faang.school.godbless.BJS2_5528;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (int i = 0; i < characterNames.length; i++) {
            FoodDeliveryTask foodDeliveryTask = new FoodDeliveryTask(characterNames[i], getFoodCount());
            executor.submit(() -> {
                foodDeliveryTask.setCharacter(foodDeliveryTask.getCharacter());
                foodDeliveryTask.setFoodAmount(foodDeliveryTask.getFoodAmount());
                foodDeliveryTask.run();
            });
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Не все задачи завершились за отведенное время");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getFoodCount() {
        return new Random().nextInt(5) + 1;
    }
}
