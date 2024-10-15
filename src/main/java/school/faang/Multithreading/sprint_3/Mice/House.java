package school.faang.Multithreading.sprint_3.Mice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    public static final int TIME_COllECT = 1;
    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> allFood = new ArrayList<>();

    public static void main(String[] args) {
        House house = new House();
        Room kitchen = new Room("Кухня");
        Room livingroom = new Room("Гостиная");
        Room badroom = new Room("Спальня");
        Room hall = new Room("Холл");
        Room gamesRoom = new Room("Игровая");
        Room redRoom = new Room("Красная комната");

        house.initializeHouse(house, kitchen, livingroom, badroom, hall, gamesRoom, redRoom);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        executor.scheduleAtFixedRate(() -> {
            house.collectFood();
            if (house.allFoodCollected()) {
                executor.shutdown();
            }
        }, 0, TIME_COllECT, TimeUnit.SECONDS);

        //TODO почитать про CountDownLatch, подумать, как его можно применить здесь
        try {
            if (executor.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Сбор еды завершен");
            }
        } catch (InterruptedException e) {
            System.out.println("Сбор еды не смог завершиться");
            executor.shutdownNow();
        }
    }


    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void initializeHouse(House house, Room kitchen, Room livingroom, Room badroom, Room hall, Room gamesRoom, Room redRoom) {
        kitchen.addFood(new Food("Apple"));
        kitchen.addFood(new Food("Bread"));
        livingroom.addFood(new Food("Cherry"));
        livingroom.addFood(new Food("Lemon"));
        badroom.addFood(new Food("Banana"));
        //TODO не забыть убрать хуй за собой
        hall.addFood(new Food("Арбуз"));
        hall.addFood(new Food("Egg"));
        gamesRoom.addFood(new Food("Pizza"));
        redRoom.addFood(new Food("Пончик"));
        house.addRoom(kitchen);
        house.addRoom(livingroom);
        house.addRoom(badroom);
        house.addRoom(hall);
        house.addRoom(gamesRoom);
        house.addRoom(redRoom);
    }

    public void collectFood() {
        Random random = new Random();
        Room room1 = rooms.get(random.nextInt(rooms.size()));
        Room room2 = rooms.get(random.nextInt(rooms.size()));

        System.out.println(Thread.currentThread().getName() + " собирает еду из двух случайных комнат: "
                + room1.getName() + ", " + room2.getName());
        if (room1.equals(room2)) {
            System.out.println(Thread.currentThread().getName() + " Сбор еды не производится в одной и той же комнате: "
                    + room1.getName() + ", " + room2.getName());
        }

        if (room1.hasFood()) {
            List<Food> foodsRoom1 = room1.getFoods();
            allFood.addAll(foodsRoom1);
            room1.removeAllFood();
        }

        if (room2.hasFood()) {
            List<Food> foodsRoom1 = room2.getFoods();
            allFood.addAll(foodsRoom1);
            room2.removeAllFood();
        }
        //TODO подумать как решить кейс, где комната опустошена
        System.out.println();
        System.out.println(Thread.currentThread().getName() + " завершил сбор еды" + allFood);
    }

    public boolean allFoodCollected() {
        return rooms.stream().noneMatch(Room::hasFood);
    }
}


