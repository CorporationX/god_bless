package faang.school.godbless.MultithreadingParallelismThread.PeterGriffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (int i = 0; i < 3; i++) {
            String character = characterNames[i];
            int foodAmount = (new Random().nextInt(15) * 3);
            executorService.execute(new FoodDeliveryTask(character, foodAmount));
        }
        executorService.shutdown();
    }
}
