package school.faang.sprint3.bjs_48365;

import lombok.Getter;
import lombok.Synchronized;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.IntPredicate;

@Getter
public class House {
    private static final Random RANDOM = new Random();
    private static final int THREAD_POOL_SIZE = 5;
    private static final int INITIAL_DELAY = 0;
    private static final int PERIOD = 30;
    private static final int TIMEOUT = 60;
    private static final int DELAY = 1000;
    private static final String[] FOODS = {
            "apple", "cheese", "bread",
            "milk", "orange", "pizza",
            "burger", "salad", "fish",
            "chocolate", "soup", "rice",
            "steak", "ice cream", "pasta"
    };

    private final List<Room> rooms;
    private final Set<Integer> excludedIndex;
    private final List<Food> totalFood = new ArrayList<>();
    private final IntPredicate excludedRoomPredicate = i -> isIndexExcluded(i);
    private final CountDownLatch latch;

    public House(List<Room> rooms) {
        this.rooms = rooms;
        this.excludedIndex = new HashSet<>(rooms.size());
        this.latch = new CountDownLatch(rooms.stream().mapToInt(r -> r.food().size()).sum());
    }

    public static void main(String[] args) {
        House house = initialize();
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
        executorService.scheduleAtFixedRate(house::collectFood, INITIAL_DELAY, PERIOD, TimeUnit.SECONDS);

        try {
            house.getLatch().await();
            executorService.shutdown();
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван!");
            Thread.currentThread().interrupt();
            executorService.shutdownNow();
        }

        System.out.println("Вся еда в доме собрана!");
    }

    @Synchronized
    public void collectFood() {
        int firstRandomRoomIndex = takeRandomRoomIndex(excludedRoomPredicate);
        int secondRandomRoomIndex = takeRandomRoomIndex(excludedRoomPredicate);

        List<Food> firstRoomFood = getFoodFromRoom(firstRandomRoomIndex);
        List<Food> secondRoomFood = getFoodFromRoom(secondRandomRoomIndex);

        totalFood.addAll(firstRoomFood);
        totalFood.addAll(secondRoomFood);

        firstRoomFood.forEach(food -> {
            latch.countDown();
            System.out.println("Еда собрана: " + food.name() + ". Осталось собрать: " + latch.getCount());
        });
        secondRoomFood.forEach(food -> {
            latch.countDown();
            System.out.println("Еда собрана: " + food.name() + ". Осталось собрать: " + latch.getCount());
        });

        firstRoomFood.clear();
        secondRoomFood.clear();
    }

    private int takeRandomRoomIndex(IntPredicate condition) {
        int randomRoomIndex = 0;

        do {
            randomRoomIndex = RANDOM.nextInt(rooms.size());
        } while (condition.test(randomRoomIndex));

        excludedIndex.add(randomRoomIndex);

        return randomRoomIndex;
    }

    private boolean isIndexExcluded(int roomIndex) {
        return excludedIndex.contains(roomIndex);
    }

    private List<Food> getFoodFromRoom(int roomIndex) {
        return rooms.get(roomIndex).food();
    }

    private static House initialize() {
        List<Food> foodList = new ArrayList<>();
        List<Room> roomList = new ArrayList<>();

        for (String food : FOODS) {
            foodList.add(new Food(food));
        }

        for (int i = 0; i < 10; i++) {
            List<Food> food = new ArrayList<>();

            food.add(foodList.get(RANDOM.nextInt(foodList.size())));
            food.add(foodList.get(RANDOM.nextInt(foodList.size())));
            food.add(foodList.get(RANDOM.nextInt(foodList.size())));

            roomList.add(new Room(food));
        }

        return new House(roomList);
    }
}
