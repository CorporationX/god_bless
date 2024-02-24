package faang.school.godbless.TomAndJerry;

import lombok.AllArgsConstructor;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class House {
    private List<Room> rooms;
    private List<Food> foodList;

    public House() {
        this.rooms = new ArrayList<>();
        this.foodList = new ArrayList<>();
    }

    public static void main(String... args) throws InterruptedException {
        House house = new House();
        house.initialize();
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executor.schedule(house::collectFood, 30, TimeUnit.SECONDS);
        }
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        System.out.println("All food collected!");
    }

    private void collectFood() {
        rooms.forEach(room -> {
            foodList.addAll(room.getFoodList());
            room.getFoodList().clear();
        });
        System.out.println(foodList + " collected!");

    }

    public void initialize() {
        int roomCount = 5;
        int foodInRoomCount = 4;
        for (int i = 0; i < roomCount; i++) {
            Room room = new Room();
            for (int k = 0; k < foodInRoomCount; k++) {
                byte[] array = new byte[7];
                new Random().nextBytes(array);
                String generatedString = new String(array, Charset.forName("UTF-8"));
                room.addFood(new Food(generatedString));
            }
            rooms.add(room);
        }
    }
}
