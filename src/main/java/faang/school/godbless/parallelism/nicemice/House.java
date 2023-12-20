package faang.school.godbless.parallelism.nicemice;

import java.util.*;
import java.util.concurrent.*;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;

public class House {
    private static final List<String> ROOM_NAMES = Arrays.asList(
            "Room-1", "Room-2", "Room-3", "Room-4", "Room-5", "Room-6", "Room-7", "Room-8");
    private static final List<String> FOOD_NAMES = Arrays.asList(
            "Pizza", "Burger", "Salad", "Sandwich", "Pasta",
            "Sushi", "Steak", "Soup", "Taco", "Cake");
    private static final List<Food> collectedFood = Collections.synchronizedList(new ArrayList<>());
    private static final int DELAY_PERIOD = 5;
    private static final int POOL_SIZE = 2;


    public static void main(String[] args) {
        List<Room> rooms = randomlyGenerateRoomsAndFood();
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(POOL_SIZE);
        List<ScheduledFuture<?>> futures = new ArrayList<>();

        int multiple = 0;
        for (int i = 0; i < rooms.size(); i++) {
            multiple = i % 2 == 0 ? multiple + 1 : multiple;
            int initDelay = DELAY_PERIOD * multiple;
            final int roomNumber = i;
            futures.add(executor.schedule(() -> collectFood(rooms.get(roomNumber)), initDelay, TimeUnit.SECONDS));
        }

        for (ScheduledFuture<?> future : futures) {
            try {
                future.get();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread was interrupted");
            } catch (ExecutionException e) {
                System.out.println("Task execution failed");
            }
        }
        executor.shutdown();
        System.out.println("All tasks are finished");

    }

    private static List<Room> randomlyGenerateRoomsAndFood() {
        RandomGenerator random = RandomGenerator.getDefault();
        return ROOM_NAMES.stream()
                .map(roomName ->
                        new Room(roomName,
                                random.ints(random.nextInt(3, 6))
                                        .mapToObj(i -> new Food(FOOD_NAMES.get(random.nextInt(FOOD_NAMES.size()))))
                                        .collect(Collectors.toList()))
                ).collect(Collectors.toList());
    }

    private static void collectFood(Room room) {
        System.out.printf("Collected food from %s\n", room.getName());
        collectedFood.addAll(room.getFoods());
        room.getFoods().clear();
    }

}
