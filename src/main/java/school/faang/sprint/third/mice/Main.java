package school.faang.sprint.third.mice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int INIT_DELAY = 0;
    private static final int PERIOD = 5;

    public static void main(String[] args) {
        List<Food> kitchenFoods = new ArrayList<>(
                List.of(new Food("Сосиска"), new Food("Пепса"), new Food("Хлеб")));
        List<Food> bathroomFoods = new ArrayList<>(
                List.of(new Food("Мазик"), new Food("Кетчуп")));
        List<Food> childrenRoomFoods = new ArrayList<>(
                List.of(new Food("Кириешки"), new Food("Лэйс"), new Food("Ваниль")));

        List<Room> rooms = List.of(new Room(kitchenFoods), new Room(bathroomFoods), new Room(childrenRoomFoods));
        House house = new House(rooms);

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(rooms.size());
        scheduledExecutorService.scheduleAtFixedRate(house::collectFood, INIT_DELAY, PERIOD, TimeUnit.SECONDS);

        try {
            int totalDelay = rooms.size() * PERIOD + 1;
            if (!scheduledExecutorService.awaitTermination(totalDelay, TimeUnit.SECONDS)) {
                scheduledExecutorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
