package ru.kraiush.threads.BJS2_24251;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
@AllArgsConstructor
public class VladController extends Thread {

    private List<TamagotchiVlad> toys;
    private String threadName;

    @Override
    public void run() {
        feedAll(toys);
        playAll(toys);
        sleepAll(toys);
        deleteTamagotchi(toys);
        addTamagotchi(toys, new TamagotchiVlad("<Lilo> in " + threadName));
    }

    List<TamagotchiVlad> feedAll(List<TamagotchiVlad> toys) {
        synchronized (toys) {
            for (TamagotchiVlad item : toys) {
                List<Food> listOfFood = new ArrayList<>();
                int setOfFood = ThreadLocalRandom.current().nextInt(1, 5);
                for (int j = 1; j <= setOfFood; j++) {
                    try {
                        Thread.sleep(ThreadLocalRandom.current().nextInt(500, 1500));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    item.feed(listOfFood, new Food(getFoodType(), ThreadLocalRandom.current().nextInt(1, 10)));
                }
                System.out.println(threadName + " - " + item.getName() + " fed: " + item.getListOfFood());
            }
            return toys;
        }
    }

    void playAll(List<TamagotchiVlad> toys) {
        synchronized (toys) {
            for (TamagotchiVlad item : toys) {
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 3000));
                    item.play(item.getName(), threadName);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    void cleanAll(List<TamagotchiVlad> toys) {
        synchronized (toys) {
            for (TamagotchiVlad item : toys) {
                item.clean(item);
            }
        }
    }

    void sleepAll(List<TamagotchiVlad> toys) {
        synchronized (toys) {
            for (TamagotchiVlad item : toys) {
                item.sleep(item, threadName);
            }
        }
    }

    List<TamagotchiVlad> deleteTamagotchi(List<TamagotchiVlad> toys) {
        synchronized (toys) {
            TamagotchiVlad tm = toys.get(toys.size() - 1);
            toys.remove(tm);
            System.out.print(threadName + " - the Tamagotchi " + tm.getName() + " deleted\n");
        }
        return toys;
    }

    List<TamagotchiVlad> addTamagotchi(List<TamagotchiVlad> toys, TamagotchiVlad tm) {
        synchronized (toys) {
            toys.add(tm);
            System.out.print("\n" + threadName + " - the Tamagotchi " + tm.getName() + " added!");
        }
        return toys;
    }

    public static String getFoodType() {
        String[] foodTypes = {"pizza", "apple", "pineapple", "pear", "beer", "banana", "grape", "candy", "chocolate", "durian"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
