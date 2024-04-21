package miceAreVeryNice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    private final List<Food> collectionFood = new ArrayList<>();
    private final List<Room> rooms = new ArrayList<>();
    private static int startIndex = 0;
    private static int endIndex = 2;


    public synchronized void collectFood() {
        if (startIndex >= rooms.size()) {
            System.out.println("All food collected");
        } else {
            for (int i = startIndex; i < endIndex; i++) {
                System.out.println("Start collect food");
                addFood(rooms.get(i).getFoodsInRoom());
                rooms.get(i).updateFoodList();
                System.out.println("End collect foods");
            }
            startIndex += 2;
            endIndex += 2;
            if (endIndex >= rooms.size()) {
                endIndex = rooms.size();
            }
        }


    }

    private void addFood(List<Food> foods) {
        if (foods.isEmpty()) {
            System.out.println("List is empty");
        } else {
            collectionFood.addAll(foods);
        }
    }

    public static void main(String[] args) {
        House house = new House();
        List<Food> foods = List.of(new Food("Pizza"), new Food("Burger"));
        for (int i = 0; i < 10; i++) {
            house.rooms.add(new Room(i, foods));
        }


        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executor.scheduleAtFixedRate(house::collectFood, 0, 5, TimeUnit.SECONDS);
        }



        try {
            executor.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();
        System.out.println("Collection food: " + house.collectionFood);
    }
}
