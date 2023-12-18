package faang.school.godbless.multi_paral.task7mice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    private List<Room> rooms = new ArrayList<>();
    private List<Food> collectedFood = new ArrayList<>();
    public synchronized void collectFood() {
        if (!rooms.isEmpty()) {
            Room room1 = rooms.remove(0);
            collectedFood.addAll(room1.getFoods());

            if (!rooms.isEmpty()) {
                Room room2 = rooms.remove(0);
                collectedFood.addAll(room2.getFoods());
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        House house = new House();

        for (int i = 0; i < 10; i++) {
            Room room = new Room();
            room.addFood(new Food("Сыр " + (i + 1)));
            room.addFood(new Food("Молоко " + (i + 1)));
            house.rooms.add(room);
        }

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 5; i++) {
            final int delay = 5 * i; // 30 секунд долго грузит
            executor.schedule(() -> {
                house.collectFood();

                if (house.rooms.isEmpty()) {
                    System.out.println("Собранная еда: " + house.collectedFood);
                    System.out.println("Еда в доме собрана!");
                }
            }, delay, TimeUnit.SECONDS);
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.MINUTES);
    }
}
