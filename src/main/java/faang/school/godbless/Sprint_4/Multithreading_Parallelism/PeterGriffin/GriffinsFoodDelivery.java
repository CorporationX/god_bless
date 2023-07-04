package faang.school.godbless.Sprint_4.Multithreading_Parallelism.PeterGriffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executor = newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for(String name : characterNames) {
            executor.submit(new FoodDeliveryTask(name, new Random().nextInt(1, 50)));
        }
        executor.shutdown();
    }
}
