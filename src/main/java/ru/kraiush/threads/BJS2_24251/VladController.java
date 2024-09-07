package ru.kraiush.threads.BJS2_24251;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
@NoArgsConstructor
public class VladController {

    public List<TamagotchiVlad> tamagotchi;

    synchronized List<TamagotchiVlad> feedAll(List<TamagotchiVlad> toys) {

        for (TamagotchiVlad item : toys) {
            List<Food> listOfFood = new ArrayList<>();
            int setOfFood = ThreadLocalRandom.current().nextInt(1, 5);
            for (int j = 1; j <= setOfFood; j++) {
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                item.feed(listOfFood, new Food(getFoodType(), ThreadLocalRandom.current().nextInt(1, 10)));
            }
            System.out.println(item.getName() + " fed: " + item.getListOfFood());
        }
        return toys;
    }

    synchronized void playAll(List<TamagotchiVlad> toys) {
        for (TamagotchiVlad item : toys) {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(2000, 5000));
                item.play(item.getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    synchronized void cleanAll(List<TamagotchiVlad> toys) {
        for (TamagotchiVlad item : toys) {
            item.clean(item);
        }
    }

    synchronized void sleepAll(List<TamagotchiVlad> toys) {
        for (TamagotchiVlad item : toys) {
            item.sleep(item);
        }
    }

    public static String getFoodType() {
        String[] foodTypes = {"pizza", "apple", "pineapple", "pear", "beer", "banana", "grape", "candy", "chocolate", "durian"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
