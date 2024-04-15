package faang.school.godbless.parallelism.familyGuy;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class GriffinsFoodDelivery {

    public static final int N_THREADS = 3;

    public static void main(String[] args) {
        ExecutorService foodDelivery = Executors.newFixedThreadPool(N_THREADS);

        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        log.info("Food delivery begins executing.");

        for (var character : characterNames) {
            int foodAmount = new Random().nextInt(0, 50);

            log.info("Submitting food delivery task for" + character);

            foodDelivery.submit(new FoolDeliveryTask(character, foodAmount));
        }

        foodDelivery.shutdown();

        try {
            foodDelivery.awaitTermination(characterNames.length * 5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("Exception was thorn during shutdown executor service.", e);
        }

        log.info("Food delivery finished.");

    }
}
