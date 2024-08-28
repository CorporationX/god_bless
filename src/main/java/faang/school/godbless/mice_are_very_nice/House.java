package faang.school.godbless.mice_are_very_nice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {

    private static List<Room> rooms = new ArrayList<>();
    private static List<Food> foods = new ArrayList<>();
    private static List<Food> collectedFood = new ArrayList<>();

    private static final int FOOD_COUNT = 7;
    private static final int POOL_SIZE = 5;
    private static final int WAITING_TIME = 3;

    public static void main(String[] args) {
        addFoodRooms();
        addFoodRooms();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(POOL_SIZE);
        int delay = 0;
        for (int i = 0; i < POOL_SIZE; i++) {
            executor.schedule(House::collectFood, delay, TimeUnit.SECONDS);
            delay += 30;
        }

        executor.shutdown();

        try {
            if (executor.awaitTermination(WAITING_TIME, TimeUnit.MINUTES)) {
                System.out.println("Еда собрана, кол-во собранных продуктов = " + collectedFood.size());
            }
        } catch (InterruptedException e) {
            System.out.println("Все сломалось");
        }
    }

    public static void collectFood() {
        for (Room room : rooms) {
            collectedFood.add(room.getFoods().get(0));
            room.getFoods().remove(room.getFoods().get(0));
            System.out.println("Добавили продукт - " + collectedFood.get(collectedFood.size() - 1).getProductName());
        }
    }

    private static void addFoodRooms() {
        Room room = new Room(new ArrayList<>());
        for (int i = 0; i < FOOD_COUNT; i++) {
            foods.add(new Food("Product" + i));
            room.getFoods().add(new Food("Product" + i));
        }

        rooms.add(room);
    }
}
