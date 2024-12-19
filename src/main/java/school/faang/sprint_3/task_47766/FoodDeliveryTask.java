package school.faang.sprint_3.task_47766;

import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private static final int MIN_DELIVERY_TIME = 1000;
    private static final Random DELIVERY_RANDOM = new Random(MIN_DELIVERY_TIME);
    private static final int MAX_DELIVERY_TIME = 5000;

    private final String character;
    private final int foodAmount;

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        String foodType = getFoodType();
        System.out.printf("%s ordered %d %s\n", character, foodAmount, foodType);

        try {
            Thread.sleep(DELIVERY_RANDOM.nextInt(MAX_DELIVERY_TIME));
        } catch (InterruptedException e) {
            System.out.println("Delivery task interrupted");
        }

        System.out.printf("%s starts eating %d %s\n", character, foodAmount, foodType);
    }
}
