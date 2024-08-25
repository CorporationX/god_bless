package thread.eight;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {

    private static List<Room> rooms = new ArrayList<>();
    private static List<Food> foods = new ArrayList<>();
    private static final int THREAD_COUNT = 5;

    public static void main(String[] args) {
        House house = new House();
        initialize();
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_COUNT);

        for (int i = 0; i < THREAD_COUNT; i++) {
            int index = i;
            executor.schedule(() -> {
                house.collectFood(index * 2, index * 2 + 1);
            }, 3, TimeUnit.SECONDS);
        }

        executor.shutdown();
        try {
            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Собранная еда: " + getFoodList(house));
                System.out.println("Вся еда в доме собрана");
            } else {
                System.out.println("Собранная еда: " + getFoodList(house));
                System.out.println("Не вся еда в доме собрана");

            }
        } catch (InterruptedException e) {
            System.out.println("Сбор еды прерван");
        }
    }

    public void collectFood(int roomIndex1, int roomIndex2) {
        if (roomIndex1 < rooms.size() && roomIndex2 < rooms.size()) {
            Room room1 = rooms.get(roomIndex1);
            Room room2 = rooms.get(roomIndex2);
            System.out.println("Поток " + Thread.currentThread().getId() + " начал работу.");

            foods.addAll(room1.getFoodList());
            foods.addAll(room2.getFoodList());

            room1.getFoodList().clear();
            System.out.println("Еда в комнате " + (roomIndex1 + 1) + " собрана.");
            room2.getFoodList().clear();
            System.out.println("Еда в комнате " + (roomIndex2 + 1) + " собрана.");
        }
    }

    private static String getFoodList(House house) {
        return foods.toString();
    }

    public static void initialize() {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            Room room = new Room();
            int foodCount = random.nextInt(5) + 1;
            for (int j = 0; j < foodCount; j++) {
                room.addFood(new Food("Food" + i, foodCount));
            }
            rooms.add(room);
        }
    }
}
