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
        this.latch = new CountDownLatch(rooms.stream().mapToInt(r -> r.getFood().size()).sum());
    }

    public static void main(String[] args) {
        House house = initialize();
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
        executorService.scheduleAtFixedRate(house::collectFood, INITIAL_DELAY, PERIOD, TimeUnit.SECONDS);

        try {
            house.getLatch().await();

            executorService.shutdown();
            if (!executorService.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван!");
            Thread.currentThread().interrupt();
            executorService.shutdownNow();
        }

        System.out.println(house.totalFood);
        System.out.println(house.rooms.get(0).getFood());
        System.out.println("Вся еда в доме собрана!");
    }

    @Synchronized
    public void collectFood() {
        int firstRandomRoomIndex = takeRandomRoomIndex(excludedRoomPredicate);
        int secondRandomRoomIndex = takeRandomRoomIndex(excludedRoomPredicate);

        List<Food> firstRoomFood = getFoodFromRoom(firstRandomRoomIndex);
        List<Food> secondRoomFood = getFoodFromRoom(secondRandomRoomIndex);

        System.out.println("Собрана еда из комнаты " + firstRandomRoomIndex + ": " + firstRoomFood);
        System.out.println("Собрана еда из комнаты " + secondRandomRoomIndex + ": " + secondRoomFood);

        // Добавляем еду в общий список
        totalFood.addAll(firstRoomFood);
        totalFood.addAll(secondRoomFood);

        // Уменьшаем счетчик для каждого предмета еды
        firstRoomFood.forEach(food -> {
            latch.countDown();
            System.out.println("Еда собрана: " + food.name() + ". Осталось собрать: " + latch.getCount());
        });
        secondRoomFood.forEach(food -> {
            latch.countDown();
            System.out.println("Еда собрана: " + food.name() + ". Осталось собрать: " + latch.getCount());
        });

//        rooms.get(firstRandomRoomIndex).setFood(new ArrayList<>());
//        rooms.get(secondRandomRoomIndex).setFood(new ArrayList<>());

        firstRoomFood.clear();
        secondRoomFood.clear();

        System.out.println(totalFood);
        System.out.println(rooms.get(firstRandomRoomIndex).getFood());
        System.out.println(rooms.get(secondRandomRoomIndex).getFood());
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
        return rooms.get(roomIndex).getFood();
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
