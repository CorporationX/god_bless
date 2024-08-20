package faang.school.godbless.BJS2_23870;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        List<Food> foods = List.of(
                new Food("Apple"),
                new Food("Banana"),
                new Food("Soda"),
                new Food("Bread"),
                new Food("Cheese"),
                new Food("Chicken"),
                new Food("Fish"),
                new Food("Cookies"),
                new Food("Milk"),
                new Food("Eggs")
        );
        List<Food> kitchen = new ArrayList<>(List.of(
                new Food("Apple"),
                new Food("Bread"),
                new Food("Milk"),
                new Food("Cheese"),
                new Food("Banana")
        ));
        List<Food> livingRoom = new ArrayList<>(List.of(
                new Food("Fish"),
                new Food("Soda"),
                new Food("Cookies"),
                new Food("Milk")
        ));
        List<Room> rooms = List.of(
                new Room("kitchen", kitchen),
                new Room("living room", livingRoom)
        );
        House house = new House(rooms);
        System.out.println(house.getRooms());
        System.out.println();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        int[] index = {0};
        Runnable deleteFood = () -> {
            if (index[0] >= foods.size()) {
                executor.shutdownNow();
            }

            Food currentFood = foods.get(index[0]);
            house.deleteFood(currentFood);
            index[0]++;
        };

        executor.scheduleWithFixedDelay(deleteFood, 10L, 5L, TimeUnit.SECONDS);

        try {
            executor.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println();
        System.out.println(house.getRooms());
    }
}
