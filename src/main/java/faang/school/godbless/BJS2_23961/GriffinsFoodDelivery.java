package faang.school.godbless.BJS2_23961;

import lombok.Getter;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
public class GriffinsFoodDelivery {
    private static final int THREAD_AMOUNT = 3;
    private final String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

    public static void main(String[] args) {
        GriffinsFoodDelivery delivery = new GriffinsFoodDelivery();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_AMOUNT);

        Arrays.stream(delivery.getCharacterNames())
                .map(name -> new FoodDeliveryTask(name, delivery.getFoodAmount()))
                .forEach(executor::submit);
        executor.shutdown();
    }

    private int getFoodAmount() {
        return ((int) (Math.random() * 100) / 4) + 1;
    }
}
