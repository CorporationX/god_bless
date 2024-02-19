package faang.school.godbless.mice;

import lombok.Data;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data

public class House {

    private static List<Food> foods;
    private  static  List<Room> rooms;
    public static void main(String[] args) {
        House house = new House();

        Room room1 = new Room("Bedroom");
        room1.addFood(new Food("Apple"));
        room1.addFood(new Food("Banana"));
        house.addRoom(room1);

        Room room2 = new Room("Kitchen");
        room2.addFood(new Food("Carrot"));
        room2.addFood(new Food("Tomato"));
        house.addRoom(room2);

        house.addFood(new Food("Apple"));
        house.addFood(new Food("Banana"));
        house.addFood(new Food("Carrot"));
        house.addFood(new Food("Tomato"));


        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

        for(int i = 0; i<5; i++){
            executor.schedule( House::collectFood, 30, TimeUnit.SECONDS);
        }

        executor.shutdown();

    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void addFood(Food food) {
        foods.add(food);
    }

    public static void collectFood(){



    }
}
