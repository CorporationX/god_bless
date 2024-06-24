package faang.school.godbless.mice_are_very_nice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        House house = new House();
        List<Room> roomsOfHouse = new ArrayList<>();

        List<Food> foodInKitchen = new ArrayList<>();
        foodInKitchen.add(new Food("cheese"));
        foodInKitchen.add(new Food("milk"));
        foodInKitchen.add(new Food("butter"));

        List<Food> foodInDiningRoom = new ArrayList<>();
        foodInDiningRoom.add(new Food("bread"));
        foodInDiningRoom.add(new Food("chicken"));
        foodInDiningRoom.add(new Food("pie"));

        List<Food> foodInLivingRoom = new ArrayList<>();
        foodInLivingRoom.add(new Food("apple"));
        foodInLivingRoom.add(new Food("orange"));
        foodInLivingRoom.add(new Food("grape"));

        List<Food> foodInBedroom1 = new ArrayList<>();
        foodInBedroom1.add(new Food("sweet"));
        foodInBedroom1.add(new Food("cooke"));
        foodInBedroom1.add(new Food("juice"));

        List<Food> foodInBedroom2 = new ArrayList<>();
        foodInBedroom2.add(new Food("bagel"));
        foodInBedroom2.add(new Food("water"));

        List<Food> foodInCellar = new ArrayList<>();
        foodInCellar.add(new Food("ice cream"));
        foodInCellar.add(new Food("wine"));

        roomsOfHouse.add(new Room("kitchen", foodInKitchen));
        roomsOfHouse.add(new Room("living room", foodInLivingRoom));
        roomsOfHouse.add(new Room("dining room", foodInDiningRoom));
        roomsOfHouse.add(new Room("bedroom1", foodInBedroom1));
        roomsOfHouse.add(new Room("bedroom2", foodInBedroom2));
        roomsOfHouse.add(new Room("cellar", foodInCellar));

        house.setRooms(roomsOfHouse);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        for (int k = 0; k < 5; k++) {
            executorService.schedule(house::collectFood, 30, TimeUnit.SECONDS);
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {}
        System.out.println("All food collected");
        System.out.println("Collected food: " + house.getFood());
        System.out.println("Food left in the rooms: " + house.getRooms());
    }
}
