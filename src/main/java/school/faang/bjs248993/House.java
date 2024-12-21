package school.faang.bjs248993;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.SECONDS;

public class House {

    private final List<Room> rooms;
    @Getter
    private final List<Food> collectedFood = new CopyOnWriteArrayList<>();
    private final Random random = new Random();

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void collectFood() {
        System.out.println(Thread.currentThread().getName() + " : started");
        if (rooms.size() < 2) {
            System.out.println("Not enough rooms to collect food.");
            return;
        }
        Room room1;
        Room room2;
        synchronized (rooms) {
            room1 = rooms.get(random.nextInt(rooms.size()));
            room2 = rooms.get(random.nextInt(rooms.size()));
            while (room1 == room2) {
                room2 = rooms.get(random.nextInt(rooms.size()));
            }
        }
        synchronized (room1) {
            synchronized (room2) {
                List<Food> foodsFromRoom1 = room1.getFoods();
                List<Food> foodsFromRoom2 = room2.getFoods();
                collectedFood.addAll(foodsFromRoom1);
                collectedFood.addAll(foodsFromRoom2);
                room1.getFoods().clear();
                room2.getFoods().clear();
            }
        }
        System.out.println(Thread.currentThread().getName() + " : finished.");
    }

    public static void main(String[] args) throws InterruptedException {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(new ArrayList<>(List.of(new Food("Apple"), new Food("Banana")))));
        rooms.add(new Room(new ArrayList<>(List.of(new Food("Bread"), new Food("Milk")))));
        rooms.add(new Room(new ArrayList<>(List.of(new Food("Cheese"), new Food("Carrot")))));
        rooms.add(new Room(new ArrayList<>(List.of(new Food("Egg"), new Food("Orange")))));

        House house = new House(rooms);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executorService.scheduleAtFixedRate(house::collectFood, 0, 30, SECONDS);
        }
        executorService.schedule(() -> {
            executorService.shutdown();
            System.out.println("Еда в доме собрана!");
            System.out.println("Collected food: " + house.getCollectedFood());
        }, 3, SECONDS);

    }
}
