package faang.school.godbless.sprint_3.multithreading_parallelism_thread.task_8_mice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    private static final String MSG_END = "Еда в доме собрана!";
    private static final int POOL_SIZE = 5;
    private static final int COUNT_FOOD = 20;

    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> collectedFood = new ArrayList<>();

    public static void main(String[] args) {
        House house = new House();
        house.fillHouse(COUNT_FOOD);
        house.showHouse();

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < POOL_SIZE; i++) {
            executorService.schedule(house::collectFood, 5, TimeUnit.SECONDS);
        }

        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();

        System.out.println(MSG_END);

    }

    private void showHouse() {
        for (Room room : rooms) {
            System.out.println(room.name() + ": " + room.foodList());
        }
    }

    private void fillHouse(int countFood) {
        Random rand = new Random();
        rooms.add(new Room("Спальная"));
        rooms.add(new Room("Чердак"));
        rooms.add(new Room("Кухня"));
        rooms.add(new Room("Ванная"));
        rooms.add(new Room("Подвал"));

        for (int i = 0; i < countFood; i++) {
            Food food = new Food("Еда_" + i);
            rooms.get(rand.nextInt(rooms.size())).foodList().add(food);
        }
    }

    public void collectFood() {

        synchronized (rooms) {
            if (!rooms.get(0).foodList().isEmpty()) {
                collectFromRoom(rooms.get(0));
            } else if (!rooms.get(1).foodList().isEmpty()) {
                collectFromRoom(rooms.get(1));
            }
        }
    }

    private void collectFromRoom(Room room) {
        synchronized (room) {

            Food food = room.foodList().remove(0);
            collectedFood.add(food);
            if (food != null) {
                System.out.printf("Поток: %s, забирает: %s, из комнаты: %s\n", Thread.currentThread().getName(), food, room.name());
            }
        }

    }


}
