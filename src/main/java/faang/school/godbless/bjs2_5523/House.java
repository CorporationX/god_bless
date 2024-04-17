package faang.school.godbless.bjs2_5523;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
@AllArgsConstructor
public class House {

    private static final int POOL_SIZE = 5;
    private static final int INTERVAL = 5;
    private static final int TIMEOUT = 600;
    private static final int FOOD_LIST_SIZE = 20;

    private List<Room> rooms;
    private List<Food> foods = new CopyOnWriteArrayList<>();

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public static void main(String[] args) {

        House house = initialize();

        System.out.println("\nFood in rooms before collect");
        house.printFoodInRooms();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(POOL_SIZE);

        for (int i = 0; i < POOL_SIZE; i++) {
            System.out.println("Start new task " + i);
            executor.schedule(() -> {
                house.collectFood();
                executor.shutdown();
            }, INTERVAL, TimeUnit.SECONDS);
        }

        try {
            while (!executor.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\nFood was collected");

        System.out.println("\nCollected List of food");
        house.getFoods().forEach(System.out::println);

        System.out.println("\nFood in rooms after collect");
        house.printFoodInRooms();
    }

    public synchronized void collectFood() {
        System.out.println("Thread " + Thread.currentThread().getName() + " is working");
        for (int i = 0; i < rooms.size(); i++) {
            List<Food> foodList = rooms.get(i).getFoodList();
            for (int j = 0; j < foodList.size(); j++) {
                Food food = foodList.get(j);
                if (food != null) {
                    foods.add(food);
                    foodList.remove(food);
                    System.out.println(food.getName() + " was moved to food list from room " + i);
                }
                if (foodList.isEmpty()) {
                    System.out.println("Room " + i + " was cleared");
                }
            }
        }
    }

    private static House initialize() {
        String[] products = new String[]{"Sausages", "Cheese", "Milk", "Paste", "Bread"};

        List<Food> foodList1 = new ArrayList<>();
        List<Food> foodList2 = new ArrayList<>();
        for (int i = 0; i < FOOD_LIST_SIZE; i++) {
            foodList1.add(new Food(products[new Random().nextInt(0, products.length)]));
            foodList2.add(new Food(products[new Random().nextInt(0, products.length)]));
        }

        Room room1 = new Room(foodList1);
        Room room2 = new Room(foodList2);

        return new House(List.of(room1, room2));
    }

    private void printFoodInRooms() {
        this.getRooms().stream()
                .flatMap(room -> room.getFoodList().stream())
                .forEach(System.out::println);
    }
}
