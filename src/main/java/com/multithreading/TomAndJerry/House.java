package com.multithreading.TomAndJerry;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Getter
public class House {
    private List<Room> rooms = new ArrayList<>();
    private List<Food> foods = new ArrayList<>();

    public static void main(String[] args) {
        List<Food> foodsInRoom1 = Arrays.asList(new Food("tomatoes"),
                new Food("cheese"));
        List<Food> foodsInRoom2 = Arrays.asList(new Food("sausage"),
                new Food("chicken"));

        Room room1 = new Room();
        room1.setFoodList(foodsInRoom1);
        Room room2 = new Room();
        room2.setFoodList(foodsInRoom2);

        House house = new House();
        house.addFood(room1);
        house.addFood(room2);

        ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(1);
        for (int i = 0; i < house.getRooms().size(); i++) {
            scheduled.schedule(house::collectFood, i * 5, TimeUnit.SECONDS);
        }
        scheduled.shutdown();
        try {
            scheduled.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void addFood(Room room) {
        rooms.add(room);
    }

    public void collectFood() {
        for (Room room : rooms) {
            Iterator<Food> iterator = room.getFoodList().iterator();
            while (iterator.hasNext()) {
                Food food = iterator.next();
                foods.add(food);
                iterator.remove();
            }
        }
        System.out.println("Собрали еду");
        System.out.println(foods);
    }
}
