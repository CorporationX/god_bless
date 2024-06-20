package faang.school.godbless.parallelism.miceareverynice;

import lombok.Getter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
public class House {
    private static final int DEFAULT_ROOMS_NUMBER = 29;
    private static final int DEFAULT_THREADS_NUMBER = 5;
    private static final int DEFAULT_DELAY = 2;
    private static final int MIN_FOOD_GENERATION_VALUE = 1;
    private static final int MAX_FOOD_GENERATION_VALUE = 5;

    private final LinkedList<Room> rooms;
    private final List<Food> collectedFood;

    public static void main(String[] args) throws InterruptedException {
        House house = new House();
        System.out.println("Комнаты:\n" + house.getRooms());

        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(DEFAULT_THREADS_NUMBER);


        int actionsNumber = (DEFAULT_ROOMS_NUMBER + 1) / 2;
        for (int i = 1; i <= actionsNumber; i++) {
            scheduledExecutorService.schedule(house::collectFood, (long) i * DEFAULT_DELAY, TimeUnit.SECONDS);
        }

        scheduledExecutorService.shutdown();
        boolean isCollected = scheduledExecutorService.awaitTermination(
                DEFAULT_DELAY * actionsNumber + 1, TimeUnit.SECONDS);
        if (isCollected) {
            System.out.println("Еда собрана");
        } else {
            System.out.println("Ожидание кончилось");
        }

        System.out.println("Комнаты:\n" + house.getRooms());
        System.out.println("Собранная еда:\n" + house.getCollectedFood());
    }

    public House() {
        this.rooms = generateRoomsFixedSizeWithRandomFood();
        this.collectedFood = new ArrayList<>();
    }

    public synchronized void collectFood() {
        System.out.println(Thread.currentThread().getName() + " collecting food");

        if (rooms == null || rooms.isEmpty()) {
            System.out.println("Illegal state exception");
            throw new IllegalStateException();
        }
        int roomsNumberToClean = rooms.size() >= 2 ? 2 : 1;
        for (int i = 0; i < roomsNumberToClean; i++) {
            System.out.println("Collecting food at " + rooms.getFirst().name());
            List<Food> foodList = rooms.getFirst().foodList();
            rooms.removeFirst();
            collectedFood.addAll(foodList);
            foodList.clear();
        }
    }

    private LinkedList<Room> generateRoomsFixedSizeWithRandomFood() {
        LinkedList<Room> rooms = new LinkedList<>();
        if (DEFAULT_ROOMS_NUMBER < 1) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < DEFAULT_ROOMS_NUMBER; i++) {
            rooms.add(new Room("Room " + i, generateFoodListRandomSize()));
        }
        return rooms;
    }

    private List<Food> generateFoodListRandomSize() {
        Random rnd = new Random();

        return IntStream.rangeClosed(0, rnd.nextInt(MIN_FOOD_GENERATION_VALUE, MAX_FOOD_GENERATION_VALUE))
                .boxed()
                .map(integer -> new Food("Food " + integer))
                .collect(Collectors.toList());
    }
}
