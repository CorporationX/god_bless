package faang.school.godbless.MiceAreVeryNice;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
public class House {
    private final static int NUMS_THREAD = 5;
    private List<Room> roms;
    private List<Food> findFood = new ArrayList<>();
    private int countRoom = 0;

    public House(List<Room> roms) {
        if (roms.isEmpty() || roms == null) {
            throw new IllegalArgumentException(
                    "The constructor of the House class received an empty or non-existent list of rooms");
        }
        this.roms = roms;
    }

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(NUMS_THREAD);
        House house = new House(Room.getListRoom());
        for (int i = 0; i < house.getRoms().size(); i++) {
            if (i % 2 == 0) {
                executor.schedule(house::collectFood, 1L, TimeUnit.SECONDS);
            } else {
                executor.submit(house::collectFood);
            }
            house.setCountRoom(house.getCountRoom() + 1);
        }
        executor.shutdown();
    }

    private void collectFood() {
        findFood.addAll(roms.get(countRoom).getFoodInRoom());
        System.out.println(String.format("Room № %d, cleansed", countRoom));
        roms.get(countRoom).getFoodInRoom().clear();
    }
}
