package feed.peter.griffin;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private final String character;
    private final int foodAmount;

    @Override
    public void run() {
        System.out.printf("Наш персонаж: %s заказал %d %s\n", this.character, this.foodAmount, this.getFoodType());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException exception) {
            throw new RuntimeException(exception);
        }

        System.out.printf(
            "Наш персонаж: %s получил и приступил к поеданию %d %s\n",
            this.character,
            this.foodAmount,
            this.getFoodType()
        );
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};

        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
