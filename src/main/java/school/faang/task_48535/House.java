package school.faang.task_48535;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class House {
    private final List<Room> rooms;
    private final List<Food> collectedFood;
    private static final int PERIOD = 2;
    private static final int TIME = 2;

    public House() {
        this.rooms = new ArrayList<>();
        this.collectedFood = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public synchronized void collectFood(int numberOfRooms) {
        List<Room> selectedRooms = rooms.stream()
                .filter(Room::hasFood)
                .limit(numberOfRooms)
                .toList();

        if (selectedRooms.size() < numberOfRooms) {
            System.out.println("Недостаточно комнат с едой!");
            return;
        }

        selectedRooms.forEach(room -> {
            collectedFood.addAll(room.getFoodList());
            System.out.println("Собрали еду из комнаты: " + room.getFoodList());
            room.getFoodList().clear();
        });
    }

    public static void main(String[] args) {
        House house = new House();

        for (int i = 1; i <= 5; i++) {
            Room room = new Room();
            for (int j = 1; j <= 3; j++) {
                room.addFood(new Food("Еда" + i + "_" + j));
            }
            house.addRoom(room);
        }

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

        Runnable task = () -> house.collectFood(3);

        executor.scheduleAtFixedRate(task, 0, PERIOD, TimeUnit.SECONDS);

        executor.schedule(() -> {
            executor.shutdown();
            try {
                if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                    System.out.println("Принудительное завершение пула потоков...");
                    executor.shutdownNow();
                } else {
                    System.out.println("Все потоки завершены");
                }
            } catch (InterruptedException e) {
                System.out.println("Ожидание завершения потоков было прервано");
                executor.shutdownNow();
                Thread.currentThread().interrupt();
            }
            System.out.println("Еда в доме собрана!");
            System.out.println("Собранная еда: " + house.collectedFood);
        }, TIME, TimeUnit.MINUTES);
    }
}
