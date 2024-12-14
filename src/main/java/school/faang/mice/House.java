package school.faang.mice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    private static List<Room> roomList = new ArrayList<>();
    private static List<Food> foodListInTheRoom = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        Food food1 = new Food("pelmeni");
        Food food2 = new Food("fried Fish");
        Food food3 = new Food("borsh");

        Food food4 = new Food("burger");
        Food food5 = new Food("hot dog");
        Food food6 = new Food("bread");

        Food food7 = new Food("milk shake");
        Food food8 = new Food("beef");
        Food food9 = new Food("pork");

        Room room1 = new Room();
        room1.addFood(food1);
        room1.addFood(food2);

        Room room2 = new Room();
        room2.addFood(food3);
        room2.addFood(food4);

        Room room3 = new Room();
        room3.addFood(food5);
        room3.addFood(food6);

        Room room4 = new Room();
        room4.addFood(food7);
        room4.addFood(food8);

        Room room5 = new Room();
        room5.addFood(food8);

        addRoom(room1);
        addRoom(room2);
        addRoom(room3);
        addRoom(room4);
        addRoom(room5);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        executorService.scheduleAtFixedRate(House::collectFood, 0, 30, TimeUnit.SECONDS);
        executorService.awaitTermination(300, TimeUnit.SECONDS);
        executorService.shutdown();
    }

    public static void addRoom(Room room) {
        roomList.add(room);
    }

    public static void collectFood() {
        Random random = new Random();
        Room room = roomList.get(random.nextInt(roomList.size()));
        Room room2 = roomList.get(random.nextInt(roomList.size()));

        if ((!room.getFoodList().isEmpty()) && (!room2.getFoodList().isEmpty())) {
            foodListInTheRoom.addAll(room.getFoodList());
            foodListInTheRoom.addAll(room2.getFoodList());

            System.out.println(room.getFoodList());
            System.out.println(room2.getFoodList());

            room.getFoodList().clear();
            room2.getFoodList().clear();
        }

        if (room.getFoodList().isEmpty() && room2.getFoodList().isEmpty()) {
            System.out.println("Эти комнаты пусты");
        }
    }
}
