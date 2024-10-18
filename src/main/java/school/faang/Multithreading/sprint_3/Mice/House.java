package school.faang.Multithreading.sprint_3.Mice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    public static final int TIME_COLLECT = 1;
    public static final int TiME_CHECK_ALL_FOOD = 5;
    public static final int POOL_THREAD = 5;

    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> collectedFood = new ArrayList<>();

    public static void main(String[] args) {
        House house = new House();
        Room kitchen = new Room("Кухня");
        Room livingroom = new Room("Гостиная");
        Room badroom = new Room("Спальня");
        Room hall = new Room("Спальня");
        Room garage = new Room("Гараж");
        Room gamesRoom = new Room("Игровая");

        house.initializeHouse(house, kitchen, livingroom, badroom, hall, gamesRoom, garage);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(POOL_THREAD);
        executor.scheduleAtFixedRate(() -> {
            house.collectFood();
            System.out.println(Thread.currentThread().getName() + " " + house.collectedFood);
        }, 0, TIME_COLLECT, TimeUnit.SECONDS);


        executor.scheduleAtFixedRate(() -> {
            if (house.isAllFoodCollected()) {
                executor.shutdown();
                System.out.println("Сбор еды завершен " + house.collectedFood);
            }
        }, 0, TiME_CHECK_ALL_FOOD, TimeUnit.SECONDS);
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void initializeHouse(House house, Room kitchen, Room livingroom, Room badroom, Room hall, Room gamesRoom, Room garage) {
        kitchen.addFood(new Food("Apple"));
        kitchen.addFood(new Food("Bread"));
        livingroom.addFood(new Food("Cherry"));
        livingroom.addFood(new Food("Lemon"));
        badroom.addFood(new Food("Banana"));
        hall.addFood(new Food("Kivy"));
        hall.addFood(new Food("Egg"));
        garage.addFood(new Food("Tomato"));
        gamesRoom.addFood(new Food("Pizza"));
        house.addRoom(kitchen);
        house.addRoom(livingroom);
        house.addRoom(badroom);
        house.addRoom(hall);
        house.addRoom(garage);
        house.addRoom(gamesRoom);
    }

    public void collectFood() {
        Random random = new Random();
        Room room1 = rooms.get(random.nextInt(rooms.size()));
        Room room2 = rooms.get(random.nextInt(rooms.size()));

        if (rooms.size() < 2) return;

        if (room1.hasFood() && room2.hasFood() && !room1.equals(room2)) {
            List<Food> foodsRoom1 = room1.getFoods();
            List<Food> foodsRoom2 = room2.getFoods();

            collectedFood.addAll(foodsRoom1);
            collectedFood.addAll(foodsRoom2);

            room1.removeAllFood();
            room2.removeAllFood();
        }
    }

    public boolean isAllFoodCollected() {
        return rooms.stream().noneMatch(Room::hasFood);
    }
}
