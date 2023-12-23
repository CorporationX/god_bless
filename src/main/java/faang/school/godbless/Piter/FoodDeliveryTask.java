package faang.school.godbless.Piter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

@AllArgsConstructor
@Data
public class FoodDeliveryTask implements Runnable {
    private String character;

    private int foodAmount;

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(character + " eats " + foodAmount + " chicken's wings");
        Thread.sleep(foodAmount * 1000L);
        System.out.println(character + " eats " + foodAmount + " chicken's wings");
    }
}
