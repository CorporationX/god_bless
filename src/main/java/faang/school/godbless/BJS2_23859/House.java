package faang.school.godbless.BJS2_23859;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Getter
public class House {
    private final List<Room> ROOMS = new ArrayList<>();
    private final List<Food> FOOD = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        House house = new House();
        initialize(house.getROOMS());

        var scheduledExecutorService = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 2; i++) {
            scheduledExecutorService.schedule(house::collectFood, 30, TimeUnit.SECONDS);
        }

        scheduledExecutorService.shutdown();
        if (scheduledExecutorService.awaitTermination(10, TimeUnit.MINUTES)) {
            System.out.printf("All food collected. Total food is %d\n", house.getFOOD().size());
            System.out.printf("Food in kitchen = %d; Food in living room = %d\n",
                    house.getROOMS().get(0).getFOOD().size(),
                    house.getROOMS().get(1).getFOOD().size());
        } else {
            System.out.println("Not all food collected");
        }
    }

    public void collectFood() {
        ROOMS.forEach(room -> {
            FOOD.addAll(room.getFOOD());
            room.getFOOD().clear();
        });
    }

    private static void initialize(List<Room> rooms) {
        var liveRoom = new Room("Living Room");
        var kitchenRoom = new Room("Kitchen");

        liveRoom.getFOOD().addAll(
                List.of(
                        new Food("Cheese"),
                        new Food("Pineapple"),
                        new Food("Milk"),
                        new Food("Bread"),
                        new Food("Chicken"),
                        new Food("Pepper")
                )
        );
        kitchenRoom.getFOOD().addAll(
                List.of(
                        new Food("Pepperoni"),
                        new Food("Meat"),
                        new Food("Sour cream"),
                        new Food("Mushrooms"),
                        new Food("Watermelon")
                )
        );
        rooms.addAll(List.of(liveRoom, kitchenRoom));

    }
}