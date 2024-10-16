package school.faang.Multithreading.sprint_3.Mice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    public static final int TIME_COllECT = 5;
    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> allFood = new ArrayList<>();


    public static void main(String[] args) {
        House house = new House();
        Room kitchen = new Room("Кухня");
        Room livingroom = new Room("Гостиная");
        Room badroom = new Room("Спальня");
        Room hall = new Room("Спальня");
        Room garage = new Room("Гараж");
        Room gamesRoom = new Room("Игровая");

        house.initializeHouse(house, kitchen, livingroom, badroom, hall, gamesRoom, garage);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        executor.scheduleAtFixedRate(() -> {
            house.collectFood();
            if(house.allFoodCollected()){
                executor.shutdown();
            }
        }, 0, TIME_COllECT, TimeUnit.SECONDS);


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
//            System.out.println(Thread.currentThread().getName() + " собирает еду из двух случайных комнат: "
//                    + room1.getName() + ", " + room2.getName());

            List<Food> foodsRoom1 = room1.getFoods();
            List<Food> foodsRoom2 = room2.getFoods();

            allFood.addAll(foodsRoom1);
            allFood.addAll(foodsRoom2);


            room1.removeAllFood();
            room2.removeAllFood();

//
            System.out.println(Thread.currentThread().getName() + " собрал еду" + allFood);
//        } else if (room1.equals(room2)) {
//            System.out.println(Thread.currentThread().getName() + " Сбор еды не производится в одной и той же комнате: "
//                    + room1.getName() + ", " + room2.getName());
//        } else {
//            System.out.println(Thread.currentThread().getName() + " Еда не собрана, комнаты уже опустошены: "
//                    + room1.getName() + ", " + room2.getName());
        }

    }

    public boolean allFoodCollected() {
        return rooms.stream().noneMatch(Room::hasFood);
    }
}
