package faang.school.godbless.family_guy;
import java.util.Random;

public class FoodDeliveryTask implements Runnable {
    private final String familyMember;
    private final int foodAmount;

    public FoodDeliveryTask(String familyMember, int foodAmount) {
        this.familyMember = familyMember;
        this.foodAmount = foodAmount;
    }

    @Override
    public void run() {
        try {
            String randomFood = getFoodType();
            int randomAwaitingTime = ((new Random()).nextInt(5) + 1) * 1000;

            System.out.printf("%s has requested %d %s%n", familyMember, foodAmount, randomFood);
            Thread.sleep(randomAwaitingTime);
            System.out.printf("%s has received %d %s%n", familyMember, foodAmount, randomFood);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
