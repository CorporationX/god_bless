package faang.school.godbless.spring_4.feed_peter_griffin;

import java.util.Random;

public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wing", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void setFoodAmount(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(1000, 6000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String food = getFoodType();
        System.out.printf("%s eats %s %s \n", getCharacter(), getFoodAmount(), food);
    }
}
