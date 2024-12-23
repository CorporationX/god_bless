package school.faang.task_48620;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class House {
    @Getter
    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> collectedFood = new ArrayList<>();
    private final Random random = new Random();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void collectFood() {
        if (rooms.size() < 2) {
            System.out.println("В доме недостаточно комнат для сбора еды.");
            return;
        }

        Room room1 = rooms.get(random.nextInt(rooms.size()));
        Room room2 = rooms.get(random.nextInt(rooms.size()));

        while (room1 == room2) {
            room2 = rooms.get(random.nextInt(rooms.size()));
        }

        System.out.println("Сбор еды из комнат: " + room1.getName() + " и " + room2.getName());

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
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        Runnable task = this::collectFood;

        executorService.scheduleAtFixedRate(task, 0, 30, TimeUnit.SECONDS);

        executorService.schedule(() -> {
            executorService.shutdown();
            System.out.println("Еда в доме собрана!");
        }, 3, TimeUnit.MINUTES);
    }
}
