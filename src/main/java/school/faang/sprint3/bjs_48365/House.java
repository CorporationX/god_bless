package school.faang.sprint3.bjs_48365;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
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
    private static final String[] FOODS = {
            "apple", "cheese", "bread",
            "milk", "orange", "pizza",
            "burger", "salad", "fish",
            "chocolate", "soup", "rice",
            "steak", "ice cream", "pasta"
    };

    private final List<Room> rooms;
    private final Set<Integer> excludedIndex;
    private List<Food> totalFood = new ArrayList<>();
    private IntPredicate excludedRoomPredicate = i -> isIndexExcluded(i);

    public House(List<Room> rooms) {
        this.rooms = rooms;
        this.excludedIndex = new HashSet<>(rooms.size());
    }

    public static void main(String[] args) {
        House house = initialize();
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
        executorService.scheduleAtFixedRate(house::collectFood, INITIAL_DELAY, PERIOD, TimeUnit.SECONDS);

        if (isAllFoodCollected(house)) {
            executorService.shutdown();
            try {
                if (!executorService.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                    executorService.shutdownNow();
                }
            } catch (InterruptedException e) {
                System.out.println("Поток был прерван!");
                Thread.currentThread().interrupt();
                executorService.shutdownNow();
            }

            System.out.println("Вся еда в доме собрана!");
        } else {
            System.out.println("Не вся еда собрана!");
        }
    }

    public synchronized void collectFood() {
        int firstRandomRoomIndex = takeRandomRoomIndex(excludedRoomPredicate);
        int secondRandomRoomIndex = takeRandomRoomIndex(excludedRoomPredicate);

        List<Food> firstRoomFood = getFoodFromRoom(firstRandomRoomIndex);
        List<Food> secondRoomFood = getFoodFromRoom(secondRandomRoomIndex);

        totalFood.addAll(firstRoomFood);
        totalFood.addAll(secondRoomFood);

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

        for (String food : FOODS) {
            foodList.add(new Food(food));
        }

        List<Room> roomList = List.of(
                new Room(List.of(foodList.get(0), foodList.get(1))),
                new Room(List.of(foodList.get(2), foodList.get(3), foodList.get(4))),
                new Room(List.of(foodList.get(5))),
                new Room(List.of(foodList.get(6), foodList.get(7))),
                new Room(List.of(foodList.get(8))),
                new Room(List.of(foodList.get(9), foodList.get(10), foodList.get(11))),
                new Room(List.of(foodList.get(12), foodList.get(13))),
                new Room(List.of(foodList.get(14)))
        );

        return new House(roomList);
    }

    private static boolean isAllFoodCollected(House house) {
        return FOODS.length == house.totalFood.size();
    }
}
