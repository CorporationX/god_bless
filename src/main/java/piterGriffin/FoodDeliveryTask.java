package piterGriffin;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
//вопрос, лучше импортировать миллион классов или всегда можно ставить звездочку?

@Data
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable{
    private String character;
    private int foodAmount;

    @Override
    public void run() {
        System.out.println(getCharacter() + " получает " + getFoodAmount() + " " + getFoodType());
        System.out.println("Ожидаем...");
        System.out.println(getCharacter() + " ест " + getFoodAmount() + " " + getFoodType());
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
