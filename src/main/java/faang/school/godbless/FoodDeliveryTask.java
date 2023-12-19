package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.random.RandomGenerator;

@Getter
@Setter
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable{
    private String character;
    private int foodAmount;

    @Override
    public void run() {
        String food = getFoodType();
        System.out.println(character +" give "+foodAmount+" "+food);
        try {
            Thread.sleep(RandomGenerator.getDefault().nextInt(1000, 5));

        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        System.out.println(character +" eat "+foodAmount+" "+food);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
