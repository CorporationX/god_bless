package faang.school.godbless;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ArrayList<Thread> list = new ArrayList<>();
        for (String names : characterNames) {
            executor.execute(() -> {
                new FoodDeliveryTask(names, new Random().nextInt(names.length())).run();
            });
        }


        executor.shutdown();
        try {
            if (executor.awaitTermination(1, TimeUnit.SECONDS)) {
                log.info("vse pokushali");
            } else {
                log.info("ne uspeli pokushat");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}