package bjs2_36111;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
public class House {
    private static final int THREAD_POOL_SIZE = 5;
    private static final int INITIAL_DELAY = 0;
    private static final int PERIOD = 30;
    private final List<Room> rooms;
    private final List<Food> collectedFood;

    public static void main(String[] args) throws InterruptedException {
        Room room1 = new Room(List.of(new Food("food1"), new Food("food2"), new Food("food3")));
        Room room2 = new Room(List.of(new Food("food4"), new Food("food5"), new Food("food6")));
        Room room3 = new Room(List.of(new Food("food7"), new Food("food8"), new Food("food9")));
        Room room4 = new Room(List.of(new Food("food10"), new Food("food11"), new Food("food12")));

        House house = new House(List.of(room1, room2, room3, room4));
        house.addRoom(new Room(List.of(new Food("food33"))));

        ScheduledExecutorService service = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);

        Thread thread = new Thread(() ->
                service.scheduleAtFixedRate(house::collectFood, INITIAL_DELAY, PERIOD, TimeUnit.SECONDS));

        thread.start();
        thread.join();

        while (!service.isShutdown()) {
            if (house.isAllFoodCollected()) {
                service.shutdown();
            }
        }

        System.out.println("It's all done!");
    }

    public House(List<Room> rooms) {
        this.rooms = Collections.synchronizedList(new ArrayList<>(rooms));
        this.collectedFood = Collections.synchronizedList(new ArrayList<>());
    }

    public void collectFood() {
        if (rooms.isEmpty()) return;

        if (rooms.size() == 1) {
            collectedFood.addAll(rooms.get(0).getFoods());
            clearRoom(0);
            return;
        }

        Random random = new Random();
        int firstRandomIndex = random.nextInt(rooms.size());
        int secondRandomIndex = random.nextInt(rooms.size());

        if (rooms.get(firstRandomIndex).hasFood() || rooms.get(secondRandomIndex).hasFood()) {
            collectedFood.addAll(rooms.get(firstRandomIndex).getFoods());
            clearRoom(firstRandomIndex);
            collectedFood.addAll(rooms.get(secondRandomIndex).getFoods());
            clearRoom(secondRandomIndex);
        }
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    private boolean isAllFoodCollected() {
        return rooms.isEmpty() || rooms.stream().noneMatch(Room::hasFood);
    }

    public void clearRoom(int index) {
        rooms.get(index).getFoods().clear();
    }
}
