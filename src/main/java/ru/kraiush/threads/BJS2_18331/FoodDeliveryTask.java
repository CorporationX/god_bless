package ru.kraiush.threads.BJS2_18331;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {

    private String character;
    private Food food;

    @Override
    public void run() {
        System.out.println(character + " get the food: " + food + " -> " + Thread.currentThread().getName() + " --- Start at: " + new Date());
        eat();
        System.out.println(character + " ate the food: " + food + " -> " + Thread.currentThread().getName() + " --- End at: " + new Date());
    }
    private void eat() {
        try {
            Thread.sleep(food.getAmount() * 1000);
            food = null;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
