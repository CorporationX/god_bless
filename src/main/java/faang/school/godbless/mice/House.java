package faang.school.godbless.mice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Getter
@Slf4j
public class House {

    private static final int N_THREADS = 5;
    private static final int DELAY = 5;
    private static final int TIMEOUT = 600;
    private List<Room> rooms;
    private static final List<Food> COLLECTED_FOOD = new ArrayList<>();

    public static void main(String[] args) {
        House house = initialize();

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(N_THREADS);
        for (int i = 0; i < 5; i++) {
            executorService.schedule(house::collectFood, DELAY, TimeUnit.SECONDS);
        }
        executorService.shutdown();
        try {
            while (!executorService.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        printCollectedFood();
        house.printRemainingFood();
    }

    public synchronized void collectFood() {
        for (Room room : rooms) {
            Food food = room.getFoodInRoom().get(0);
            COLLECTED_FOOD.add(food);
            room.getFoodInRoom().remove(0);
        }
    }

    private static House initialize() {
        List<Room> roomList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            List<Food> foods = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                foods.add(new Food("Food_" + (i + 1) + "." + (j + 1)));
            }
            roomList.add(new Room(foods));
        }
        return new House(roomList);
    }

    public static void printCollectedFood() {
        COLLECTED_FOOD.forEach(System.out::println);
    }

    public void printRemainingFood() {
        rooms.stream()
                .flatMap(room -> room.getFoodInRoom().stream())
                .forEach(System.out::println);
    }
}
