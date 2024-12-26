package school.faang.task_49006;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.*;

@Slf4j
public class House {
    private static final int MAX_NUMBER_OF_THREADS = 5;
    private static final long INITIAL_DELAY = 0;
    private static final long PERIOD_TIME = 30;
    private static final long WAITING_TIME = 2;
    private static final long TIMEOUT = 1;

    private static final List<Room> rooms = new ArrayList<>();
    private final List<Food> collectedFood = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void collectFood() {
        Random random = new Random();

        Room room1 = rooms.get(random.nextInt(rooms.size()));
        Room room2 = rooms.get(random.nextInt(rooms.size()));

        while (room1 == room2) {
            room2 = rooms.get(random.nextInt(rooms.size()));
        }

        synchronized (room1) {
            synchronized (room2) {
                if (room1.hasFood() || room2.hasFood()) {
                    collectedFood.addAll(room1.collectFood());
                    collectedFood.addAll(room2.collectFood());
                    log.info("Collected: {}", collectedFood);
                    System.out.println("Collectd food from two rooms: " + collectedFood);
                } else {
                    System.out.println("There are no foods for collect.");
                }
            }
        }
    }

    public void printCollectedFood() {
        System.out.println("Total collected food: " + collectedFood);
    }

    public static synchronized boolean hasFoodInAnyRoom() {
        return rooms.stream().anyMatch(Room::hasFood);
    }

    public static void main(String[] args) {
        House house = new House();

        house.addRoom(new Room(Arrays.asList(new Food("Apple"), new Food("Bread"))));
        house.addRoom(new Room(Arrays.asList(new Food("Milk"), new Food("Cheese"))));
        house.addRoom(new Room(Arrays.asList(new Food("Meat"), new Food("Vegetables"))));
        house.addRoom(new Room(Arrays.asList(new Food("Fish"), new Food("Fruits"))));


        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(MAX_NUMBER_OF_THREADS);

        Runnable task = () -> {
            house.collectFood();
            if (!house.hasFoodInAnyRoom()) {
                executorService.shutdown();
                System.out.println("All food in the rooms are collected!");
                house.printCollectedFood();
            }
        };


        for (int i = 0; i < MAX_NUMBER_OF_THREADS; i++) {
            executorService.scheduleAtFixedRate(task, INITIAL_DELAY, PERIOD_TIME, TimeUnit.SECONDS);
        }

        executorService.schedule(() -> {
            executorService.shutdown();
            try {
                if (executorService.awaitTermination(TIMEOUT, TimeUnit.MINUTES)) {
                    System.out.println("Food is collected.");
                    house.printCollectedFood();
                } else {
                    System.out.println("The threads failed to complete within the allotted time.");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread's poll was interrupted.");
            }
        }, WAITING_TIME, TimeUnit.MINUTES);
    }
}
