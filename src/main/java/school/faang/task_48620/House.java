package school.faang.task_48620;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class House {
    private static final int MIN_ROOMS_REQUIRED = 2;
    private static final int THREAD_POOL_SIZE = 5;
    private static final int INITIAL_DELAY = 0;
    private static final int COLLECT_INTERVAL = 30; // seconds

    @Getter
    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> collectedFood = new ArrayList<>();
    private final Random random = new Random();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void collectFood() {
        if (rooms.size() < MIN_ROOMS_REQUIRED) {
            System.out.println("В доме недостаточно комнат для сбора еды.");
            return;
        }

        List<Room> uniqueRooms = new ArrayList<>(rooms);
        Room room1 = uniqueRooms.remove(random.nextInt(uniqueRooms.size()));
        Room room2 = uniqueRooms.get(random.nextInt(uniqueRooms.size()));

        synchronized (this) {
            List<Food> foodFromRoom1 = new ArrayList<>(room1.getFoodList());
            List<Food> foodFromRoom2 = new ArrayList<>(room2.getFoodList());

            room1.getFoodList().clear();
            room2.getFoodList().clear();

            collectedFood.addAll(foodFromRoom1);
            collectedFood.addAll(foodFromRoom2);
        }

        System.out.println("Еда собрана. Общий список: ");
        collectedFood.forEach(food -> System.out.print(food.getName() + " "));
        System.out.println("\n");
    }

    public void startCollectingFood() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);

        Runnable collectFoodTask = this::collectFood;

        executorService.scheduleAtFixedRate(collectFoodTask, INITIAL_DELAY, COLLECT_INTERVAL, TimeUnit.SECONDS);

        new Thread(() -> {
            while (true) {
                synchronized (this) {
                    if (rooms.stream().allMatch(room -> room.getFoodList().isEmpty())) {
                        executorService.shutdown();
                        break;
                    }
                }

                try {
                    if (executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                        System.out.println("Еда в доме собрана!");
                        break;
                    }
                } catch (InterruptedException e) {
                    System.out.println("Главный поток был прерван.");
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }).start();
    }
}
