package faang.school.godbless.griffins;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;
import java.util.stream.IntStream;

@Getter
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        String food = getFoodType();
        System.out.println(character + " получает " + foodAmount + " " + food);
        try {
            Thread.sleep(1250);
            IntStream.range(1, foodAmount + 1)
                    .boxed()
                    .peek(i -> System.out.println("#" + i + " " + food + " доставлено"))
                    .toList();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(character + " все получил и съел " + food + " в количестве: " + foodAmount);
    }
}
