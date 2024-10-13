package school.faang.miceverynice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        List<Food> foodsInKitchen = new ArrayList<>();
        List<Food> foodsOnHall = new ArrayList<>();
        List<Food> foodsInDiningRoom = new ArrayList<>();
        List<Food> foodsInLivingRoom = new ArrayList<>();
        List<Food> foodsInBedroom = new ArrayList<>();
        List<Room> roomsWithFood = new ArrayList<>();
        List<Food> collectedFood = new ArrayList<>();

        Food apple = new Food("Apple");
        Food cherry = new Food("Cherry");
        Food banana = new Food("Banana");
        Food strawberry = new Food("Strawberry");
        Food grapes = new Food("Grapes");
        Food cheese = new Food("Cheese");
        Food cake = new Food("Cake");
        Food cookie = new Food("Cookie");
        Food milk = new Food("Milk");

        foodsInKitchen.add(apple);
        foodsInKitchen.add(cherry);
        foodsOnHall.add(banana);
        foodsOnHall.add(strawberry);
        foodsInDiningRoom.add(grapes);
        foodsInDiningRoom.add(cheese);
        foodsInLivingRoom.add(cake);
        foodsInLivingRoom.add(cookie);
        foodsInBedroom.add(milk);

        Room kitchen = new Room("kitchen", foodsInKitchen);
        Room hall = new Room("hall", foodsOnHall);
        Room diningRoom = new Room("dining room", foodsInDiningRoom);
        Room livingRoom = new Room("living room", foodsInLivingRoom);
        Room bedroom = new Room("bedroom", foodsInBedroom);

        roomsWithFood.add(kitchen);
        roomsWithFood.add(hall);
        roomsWithFood.add(diningRoom);
        roomsWithFood.add(livingRoom);
        roomsWithFood.add(bedroom);

        House house = new House(roomsWithFood);

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);
        scheduler.scheduleAtFixedRate(() -> {
            List<Food> newCollectedFood = house.collectFood();
            collectedFood.addAll(newCollectedFood);
            System.out.println("\nСобрана еда: " + collectedFood);
        }, 0, 30, TimeUnit.SECONDS);

        scheduler.schedule(() -> {
            scheduler.shutdown();
            System.out.println("Еда в доме собрана!");
        }, 2, TimeUnit.MINUTES);
    }
}
