package faang.school.godbless.tomAndJerry;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {

    public static final int LIMIT_FOR_ROOMS = 2;
    public static final int NUMBER_OF_THREADS = 5;
    public static final long THREAD_DELAY = 2L;
    public static final long COMMON_DELAY = 10L;

    public static List<Room> roomsWithFoods;
    public static List<Food> collectedFood;

    public static void main(String[] args) throws InterruptedException {
        printInfoAboutFoodLists();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(NUMBER_OF_THREADS);
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            executor.scheduleAtFixedRate(House::collectFood, THREAD_DELAY, THREAD_DELAY, TimeUnit.SECONDS);
        }

        try {
            if (!executor.awaitTermination(COMMON_DELAY, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
            System.out.println("\nFood has been collected\n");
        } catch (InterruptedException e) {
            System.out.println("\nOops, somebody didn't make it in time\n");
            executor.shutdownNow();
        }

        printInfoAboutFoodLists();
    }

    private static void collectFood() {
        if (roomsWithFoods != null) {
            int counterOfRooms = 0;
            for (Room room : roomsWithFoods) {
                if (!room.getFoods().isEmpty() && counterOfRooms < LIMIT_FOR_ROOMS && room.getLock() == 0) {
                    room.setLock(1);
                    List<Food> foodInRoom = room.getFoods();
                    collectedFood.addAll(foodInRoom);
                    foodInRoom.clear();
                    counterOfRooms++;
                    room.setLock(0);
                }
            }
        }
    }

    private static void printInfoAboutFoodLists() {
        System.out.println("Food size from all rooms " +
                roomsWithFoods.stream().mapToInt(room -> room.getFoods().size()).sum());
        System.out.println("Rooms with foods " + roomsWithFoods);
        System.out.println("Collected foods " + collectedFood);
        System.out.println("Collected food size " + collectedFood.size());
    }

    static {
        Food apple = new Food("apple");
        Food banana = new Food("banana");
        Food pineapple = new Food("pineapple");
        Food tea = new Food("tea");
        Food coffee = new Food("coffee");
        Food water = new Food("water");
        Food rise = new Food("rise");

        Room kitchen = new Room("kitchen");
        Room bathroom = new Room("bathroom");
        Room garage = new Room("garage");
        Room livingRoom = new Room("living");
        Room bedRoom = new Room("bedroom");

        kitchen.addFoodToRoom(apple);
        kitchen.addFoodToRoom(banana);
        kitchen.addFoodToRoom(pineapple);
        kitchen.addFoodToRoom(tea);
        kitchen.addFoodToRoom(coffee);
        bathroom.addFoodToRoom(rise);
        bathroom.addFoodToRoom(water);
        garage.addFoodToRoom(apple);
        garage.addFoodToRoom(banana);
        garage.addFoodToRoom(pineapple);
        livingRoom.addFoodToRoom(tea);
        livingRoom.addFoodToRoom(coffee);
        livingRoom.addFoodToRoom(water);
        bedRoom.addFoodToRoom(apple);
        bedRoom.addFoodToRoom(rise);
        bedRoom.addFoodToRoom(coffee);

        roomsWithFoods = new ArrayList<>(List.of(kitchen, bathroom, garage, livingRoom, bedRoom));
        collectedFood = new ArrayList<>();
    }
}
