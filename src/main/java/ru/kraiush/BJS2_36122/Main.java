package ru.kraiush.BJS2_36122;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int POOL_SIZE = 5;

    public static void main(String[] args) {
        House house = new House(new ArrayList<>(Arrays.asList(
                new Room(new ArrayList<>(Arrays.asList(
                        new Food("Spaghetti Carbonara"),
                        new Food("Chicken Alfredo"),
                        new Food("Beef Stroganoff"),
                        new Food("Grilled Salmon")
                ))),
                new Room(new ArrayList<>(Arrays.asList(
                        new Food("Caesar Salad"),
                        new Food("Margherita Pizza"),
                        new Food("Beef Tacos")
                ))),
                new Room(new ArrayList<>(Arrays.asList(
                        new Food("Chicken Curry"),
                        new Food("Shrimp Scampi"),
                        new Food("Lasagna")
                ))),
                new Room(new ArrayList<>(Arrays.asList(
                        new Food("Grilled Cheese Sandwich"),
                        new Food("Roast Beef with Mashed Potatoes"),
                        new Food("Fish and Chips"),
                        new Food("Pad Thai")
                ))),
                new Room(new ArrayList<>(Arrays.asList(
                        new Food("Chicken Teriyaki"),
                        new Food("Eggplant Parmesan"),
                        new Food("Lasagna")
                )))
        )));

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(POOL_SIZE);
        executorService.scheduleAtFixedRate(() -> {
            house.collectFood();
            if (house.allFoodCollected()) {
                executorService.shutdown();
                System.out.println("All food was collected!");
            }
        }, 0, 15, TimeUnit.SECONDS);
    }
}
