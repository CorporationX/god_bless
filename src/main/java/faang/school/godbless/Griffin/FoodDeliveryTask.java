package faang.school.godbless.Griffin;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable{
    private String character;
    private int foodAmount;

    private String getFoodType(){
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        int delaySeconds = new Random().nextInt(5) + 1;
        String foodtype = this.getFoodType();
        int foodAmount = this.getFoodAmount();

        try{
            Thread.sleep(foodAmount * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(character +  " получает" + foodAmount + " " + foodtype);
    }

}
