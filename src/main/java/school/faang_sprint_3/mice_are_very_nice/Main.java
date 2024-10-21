package school.faang_sprint_3.mice_are_very_nice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) {
        var house = new House(Arrays.asList(
                new Room("Kitchen", new ArrayList<>(Arrays.asList(
                        new Food("Pineapple"), new Food("Pickles"), new Food("Cucumbers")))),
                new Room("Living Room", new ArrayList<>(Arrays.asList(
                        new Food("Cheese"), new Food("Oil"), new Food("Flour")))),
                new Room("Bathroom", new ArrayList<>(Arrays.asList(
                        new Food("Oranges"), new Food("Apples"), new Food("Bananas")))),
                new Room("Dining Room", new ArrayList<>(Arrays.asList(
                        new Food("Coconut"), new Food("Powder"), new Food("Snacks"))))
        ));

        var threadPool = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
        threadPool.scheduleAtFixedRate(() -> {
            if (house.isAllFoodCollected()) {
                threadPool.shutdownNow();
                house.collectFood().stream().map(Food::toString).forEach(System.out::print);
                System.out.println("All food are collected");
                house.rooms().stream().filter(room -> !room.hasFood()).forEach(System.out::println);
            }
        }, 0, 30, TimeUnit.SECONDS);
    }
}

