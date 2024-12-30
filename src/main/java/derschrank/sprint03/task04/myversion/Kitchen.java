package derschrank.sprint03.task04.myversion;

import java.util.ArrayList;
import java.util.List;

public class Kitchen implements KitchenInterface {
    List<Food> leftoversOfFood;

    public Kitchen() {
        leftoversOfFood = new ArrayList<>();
    }

    public synchronized boolean receiveFood(Food food) {
        System.out.println("Kitchen become leftover: " + food + " from: " + Thread.currentThread().getName());
        return leftoversOfFood.add(food);
    }

    @Override
    public int getCountOfFood() {
        return leftoversOfFood.size();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Leftovers of food: ")
                .append(leftoversOfFood.size())
                .append(" ").append(leftoversOfFood);

        return result.toString();
    }
}
