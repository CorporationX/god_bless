package faang.school.godbless.mice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    private static List<Room> roomList;
    private static List<Food> availableFood;

    public static void main(String[] args) {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        roomList = new ArrayList<>();

        fillInHouse();

        for (int i = 0; i < roomList.size(); i++){
            executor.schedule(House::collectFood, 30 * i, TimeUnit.SECONDS);
        }

        executor.shutdown();

        availableFood = new ArrayList<>();
        try {
            executor.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Food collected");
        availableFood.stream().forEach(System.out::println);
    }

    private static void collectFood(){
        for (int i = 0; i < roomList.size(); i++){
            availableFood.addAll(roomList.get(i).getFoodList());
            roomList.get(i).getFoodList().clear();
        }
    }

    private static void fillInHouse(){
        Room room1 = new Room(fillInRooms());
        Room room2 = new Room(fillInRooms());
        roomList.add(room1);
        roomList.add(room2);
    }

    private static List<Food> fillInRooms(){
        String[] availableFood = {"cheese", "bread", "cookies", "chocolate", "chips"};
        List<Food> food = new ArrayList<>();
        for (int i = 0; i <= 10; i++){
            food.add(new Food(availableFood[new Random().nextInt(availableFood.length)]));
        }

        return food;
    }
}
