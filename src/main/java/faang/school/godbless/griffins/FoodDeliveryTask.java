package faang.school.godbless.griffins;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {

    private final String character;
    private final int foodAmount;

    private final long SLEEP_TIMER = 5000L;

    private final Random GREAT_RANDOM = new Random();

    @Override
    public void run() {
        String food = getFoodType();
        System.out.println("Start feeding " + character + " with " + foodAmount + " " + food);
        try {
            Thread.sleep(SLEEP_TIMER);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(character + " got " + foodAmount + " " + food);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[GREAT_RANDOM.nextInt(foodTypes.length)];
    }
}
