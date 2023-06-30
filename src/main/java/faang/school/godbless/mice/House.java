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
        roomList = new ArrayList<>();
        availableFood = new ArrayList<>();
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        fillInHouse();

        for (int i = 0; i < roomList.size(); i++){
            executor.schedule(House::collectFood, 5, TimeUnit.SECONDS);
        }

        executor.shutdown();
        try {
            executor.awaitTermination(15, TimeUnit.SECONDS);
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
        int i = 0;
        while (i <= 10){
            food.add(new Food(availableFood[new Random().nextInt(availableFood.length)]));
            i++;
        }

        return food;
    }
}
