package school.faang.tomandjerry;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
public class House {
    public static final int CORE_POOL_SIZE = 5;
    private static List<Food> collectedFood = new ArrayList<>();
    private List<Room> rooms;

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public static List<Room> initialization() {
        List<Room> initializedRooms = new ArrayList<>();
        String[] foods = {"tomato paste", "broccoli", "chili pepper", "cherry tomatoes"
                , "peanut butter", "meat", "peaches", "cheese", "cupcakes", "lemon", "bananas"};
        Random random = new Random();
        int randomCountOfRooms = random.nextInt(1, 11);
        for (int i = 0; i < randomCountOfRooms; i++) {
            Room room = new Room();
            int randomCountOfFoods = random.nextInt(1, 11);

            for (int j = 0; j < randomCountOfFoods; j++) {
                String someFood = foods[random.nextInt(foods.length)];
                room.addFood(new Food(someFood));
            }
            initializedRooms.add(room);
        }
        return initializedRooms;
    }

    public static void main(String[] args) {
        House house = new House(initialization());
        System.out.println("Count of rooms in the house: " + house.getRooms().size());
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(CORE_POOL_SIZE);
        for (int i = 0; i < house.getRooms().size(); i++) {
            scheduler.scheduleAtFixedRate(() -> {
                house.collectFood();
                if (house.allFoodCollected()) {
                    scheduler.shutdown();
                    System.out.println("The food in the house is collected");
                }
            }, 0, 30, TimeUnit.SECONDS);
        }
        System.out.println("Collected food: " + collectedFood);
    }

    public void collectFood() {
        Random random = new Random();
        Room firstRoom = rooms.get(random.nextInt(rooms.size()));
        Room secondRoom = rooms.get(random.nextInt(rooms.size()));
        if (firstRoom.hasFood() && secondRoom.hasFood()) {
            collectedFood.addAll(firstRoom.getFoodInRoom());
            collectedFood.addAll(secondRoom.getFoodInRoom());
        }
        firstRoom.removeAllFood(firstRoom.getFoodInRoom());
        secondRoom.removeAllFood(secondRoom.getFoodInRoom());
        this.getRooms().remove(firstRoom);
        this.getRooms().remove(secondRoom);
    }

    public boolean allFoodCollected() {
        for (Room room : rooms) {
            if (room.hasFood()) {
                return false;
            }
        }
        return true;
    }
}
