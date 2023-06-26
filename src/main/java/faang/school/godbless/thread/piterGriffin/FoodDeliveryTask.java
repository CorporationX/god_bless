package faang.school.godbless.thread.piterGriffin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Getter
public class FoodDeliveryTask implements Runnable {
    private String characterName;
    private int foodAmount;

    @SneakyThrows
    @Override
    public void run() {
        System.out.printf("На горизонте показалась еда в количстве %d. %s! Хватай быстрей!\n", foodAmount, characterName);
        TimeUnit.SECONDS.sleep(2);
        System.out.printf("%s получил %d %s. Сидит ест.\n", characterName, foodAmount, getFoodType());
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
