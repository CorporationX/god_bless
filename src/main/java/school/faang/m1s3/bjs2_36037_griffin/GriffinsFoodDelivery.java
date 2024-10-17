package school.faang.m1s3.bjs2_36037_griffin;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        ExecutorService service = Executors.newFixedThreadPool(3);

        Arrays.stream(characterNames).forEach(character -> {
            service.execute(new FoodDeliveryTask(character));
        });

        service.shutdown();

        try {
            if (!service.awaitTermination(60, TimeUnit.SECONDS)) {
                service.shutdownNow();
                System.out.println("Lunch is over!");
            } else {
                System.out.println("Family is happy!");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
