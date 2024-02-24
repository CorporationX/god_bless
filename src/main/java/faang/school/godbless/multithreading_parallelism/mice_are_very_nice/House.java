package faang.school.godbless.multithreading_parallelism.mice_are_very_nice;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
@AllArgsConstructor
public class House {
    private List<Room> housesRoom;
    private final List<Food> collectedFood = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        House house = House.initialize();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executor.schedule(house::collectFood, 30, TimeUnit.SECONDS);
        }
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        System.out.println(house.getHousesRoom());
        System.out.println(house.getCollectedFood());
    }

    public void collectFood() {
        housesRoom.stream().forEach(room -> {
            collectedFood.addAll(room.getFoodList());
            room.getFoodList().clear();
        });
    }

    private void addFoodToRoom(Room room, Food food) {
        if (room != null && food != null) {
            room.getFoodList().add(food);
        }
    }

    private static House initialize() {
        Room kitchen = new Room(new ArrayList<>(Arrays.asList(
                new Food("Яблоко", 2),
                new Food("Курица", 2),
                new Food("Суп", 1)
        )));

        Room bedroom = new Room(new ArrayList<>(Arrays.asList(
                new Food("Чипсы", 1),
                new Food("Газировка", 2)
        )));

        Room livingRoom = new Room(new ArrayList<>(Arrays.asList(
                new Food("Сухарики", 2)
        )));


        return new House(Arrays.asList(kitchen, bedroom, livingRoom));
    }
}
