package ru.kraiush.threads.BJS2_24251;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class TamagotchiVlad implements Runnable {

    private String name;

    List<Food> listOfFood;

    public TamagotchiVlad(String name) {
        this.name = name;
    }

    public void feed(List<Food> listOfFood, Food food) {
        listOfFood.add(food);
        this.listOfFood = listOfFood;
    }

    public synchronized void play(String name) {
        System.out.println("just to play with " + name);
    }

    public synchronized void clean(TamagotchiVlad item) {
        item.setListOfFood(null);
    }

    public synchronized void sleep(TamagotchiVlad item) {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(2000, 5000));
            System.out.println(item.getName() + " - it's time to get some sleep!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {

    }
}
