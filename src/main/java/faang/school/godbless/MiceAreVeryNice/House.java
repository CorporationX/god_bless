package faang.school.godbless.MiceAreVeryNice;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
public class House {
    private static final int NUMS_THREAD = 5;
    private final Object lock = new Object();
    private List<Food> findFood = new ArrayList<>();
    private List<Room> rooms;
    private int countRoom = 1;

    public House(List<Room> rooms) {
        if (rooms.isEmpty() || rooms == null) {
            throw new IllegalArgumentException(
                    "The constructor of the House class received an empty or non-existent list of rooms");
        }
        this.rooms = rooms;
    }

    @SneakyThrows
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(NUMS_THREAD);
        House house = new House(Room.getListRoom());
        for (int i = 0; i < house.getRooms().size(); i++) {
            if (i % 2 != 0) {
                executor.schedule(house::collectFood, 30, TimeUnit.SECONDS);
            } else {
                executor.submit(house::collectFood);
            }
        }
        executor.shutdown();
    }

    private void collectFood() {
        synchronized (lock) {
            findFood.addAll(rooms.get(countRoom).getFoodInRoom());
            System.out.println(String.format("Room № %d, cleansed", countRoom));
            rooms.get(countRoom).getFoodInRoom().clear();
            countRoom++;
        }
    }
}
